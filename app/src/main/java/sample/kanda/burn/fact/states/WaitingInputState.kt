package sample.kanda.burn.fact.states

import android.view.ViewGroup
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fact_waiting_input_view.view.*
import sample.kanda.app.structure.Navigator
import sample.kanda.app.structure.ViewController
import sample.kanda.burn.fact.FactViewModel
import sample.kanda.burn.loadGif
import sample.kanda.burn.widget.LceContainer
import java.util.concurrent.TimeUnit

/**
 * Created by caique on 3/15/18.
 */
class WaitingInputState(private val vm: FactViewModel,
                        private val container: ViewGroup,
                        private val navigator: Navigator,
                        private val scheduler: Scheduler) : ViewController {

    private val lceView: LceContainer = LceContainer(container.context)
    private val disposable by lazy { CompositeDisposable() }

    init {
        lceView.setUpView(ViewByState.WAITING_INPUT_STATE)
        container.addView(lceView)
        setUpView()
        startActions()
    }

    override fun startActions() {
        lceView.rootView.termEntry?.editText?.apply {
            val obs = RxTextView.textChangeEvents(this)
                    .debounce(1000, TimeUnit.MILLISECONDS, scheduler)
                    .filter { it.text().toString().isNotEmpty() }
                    .flatMap { vm.getFact(it.text().toString()) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { navigator.changeState(it) }

            disposable.add(obs)
        }
    }

    private fun setUpView() {
        lceView.rootView.gif.loadGif("https://media.giphy.com/media/13fR00PIYwb7Gg/giphy.gif")
    }

    override fun dispose() {
        container.removeView(lceView)
        disposable.dispose()
    }
}