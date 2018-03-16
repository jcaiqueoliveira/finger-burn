package sample.kanda.burn.fact

import android.view.ViewGroup
import io.reactivex.Scheduler
import sample.kanda.app.structure.Navigator
import sample.kanda.app.structure.SUCCESS
import sample.kanda.app.structure.State
import sample.kanda.app.structure.ViewController
import sample.kanda.burn.fact.states.Success
import sample.kanda.burn.fact.states.WAITING_INPUT
import sample.kanda.burn.fact.states.WaitingInputState

/**
 * Created by caique on 3/14/18.
 */


class FactNavigator(val scheduler: Scheduler) : Navigator {
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
            is WAITING_INPUT -> {
                WaitingInputState(viewModel, container, this, scheduler)
                        .apply { listState.add(this) }
            }

            is SUCCESS<*> -> {
                clear()
                Success(state.value as List<FactView>, container)
            }
        }
    }
}