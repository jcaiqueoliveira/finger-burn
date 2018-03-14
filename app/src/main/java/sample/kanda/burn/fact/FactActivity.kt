package sample.kanda.burn.fact

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.LazyKodein
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.activity_main.*
import sample.kanda.burn.R
import sample.kanda.burn.viewModelProvider

class FactActivity : AppCompatActivity() {
    private val kodein by LazyKodein(appKodein)

    private val viewModel by viewModelProvider { kodein.instance<FactViewModel>() }

    private val navigator by lazy { kodein.instance<FactNavigator>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.init(rootView, viewModel)

        viewModel.initViewState()
                .subscribe { navigator.changeState(it) }
    }

    override fun onDestroy() {
        navigator.clear()
        super.onDestroy()
    }
}
