package sample.kanda.burn.fact

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.LazyKodein
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.instance
import io.reactivex.Scheduler
import kotlinx.android.synthetic.main.activity_main.*
import sample.kanda.app.structure.Navigator
import sample.kanda.app.structure.SUCCESS
import sample.kanda.app.structure.State
import sample.kanda.burn.R
import sample.kanda.burn.fact.states.Success
import sample.kanda.burn.fact.states.WAITING_INPUT
import sample.kanda.burn.fact.states.WaitingInputState
import sample.kanda.burn.viewModelProvider

class FactActivity : AppCompatActivity(), Navigator {

    private val kodein by LazyKodein(appKodein)

    private val viewModel by viewModelProvider { kodein.instance<FactViewModel>() }

    private val scheduler by lazy { kodein.instance<Scheduler>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.initViewState()
                .subscribe { changeState(it) }
    }

    override fun changeState(state: State) {

        when (state) {
            is WAITING_INPUT -> {
                WaitingInputState(viewModel, rootView, this, scheduler)
            }

            is SUCCESS<*> -> {
                Success(state.value as List<FactView>, rootView)
            }
        }
    }
}
