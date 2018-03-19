package sample.kanda.burn.fact.states

import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fact_success_state.view.*
import sample.kanda.app.structure.ViewController
import sample.kanda.burn.fact.FactView
import sample.kanda.burn.widget.LceContainer

/**
 * Created by caique on 3/15/18.
 */
class Success(private val facts: List<FactView>, private val container: ViewGroup) : ViewController {

    private val lceView: LceContainer = LceContainer(container.context)

    init {
        lceView.setUpView(ViewByState.SUCCESS_STATE)
        container.addView(lceView)
        startActions()
    }

    override fun startActions() {
        setUpView()
    }

    override fun dispose() {
        container.removeView(lceView)
    }

    private fun setUpView() {
        val manager = LinearLayoutManager(container.context)
        lceView.rootView.listFacts.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = SuccessAdapter(facts, onClickListener())
        }
    }

    private fun onClickListener(): ClickListener {
        return object : ClickListener {
            override fun onClick(item: FactView) {
                //todo
            }
        }
    }
}