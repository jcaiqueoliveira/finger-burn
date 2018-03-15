package sample.kanda.burn.fact

import android.view.ViewGroup
import sample.kanda.app.structure.Navigator
import sample.kanda.app.structure.State
import sample.kanda.app.structure.ViewController
import sample.kanda.burn.fact.states.LoadingState
import sample.kanda.burn.fact.states.WAITING_INPUT

/**
 * Created by caique on 3/14/18.
 */


class FactNavigator : Navigator {
    private lateinit var container: ViewGroup
    private lateinit var viewModel: FactViewModel

    private val listState by lazy { mutableListOf<ViewController>() }

    override fun clear() {
        listState.forEach { it.dispose() }
    }

    fun init(container: ViewGroup, viewModel: FactViewModel) {
        this.container = container
        this.viewModel = viewModel
    }

    override fun changeState(state: State) {
        when (state) {
            is WAITING_INPUT -> LoadingState(viewModel, container, this)
                    .apply { listState.add(this) }
        }
    }
}