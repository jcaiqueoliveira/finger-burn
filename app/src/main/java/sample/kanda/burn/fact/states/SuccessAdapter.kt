package sample.kanda.burn.fact.states

import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fact_item_success_layout.view.*
import sample.kanda.burn.R
import sample.kanda.burn.fact.FactView

/**
 * Created by caique on 3/15/18.
 */
class SuccessAdapter(private val facts: List<FactView>,
                     private val clickListener: ClickListener) : RecyclerView.Adapter<FactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fact_item_success_layout, parent, false)
        return FactViewHolder(view)
    }

    override fun getItemCount(): Int = facts.size

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        facts[position].apply {
            holder.setItem(this)
            holder.clickItem { clickListener.onClick(this) }
        }
    }

}

class FactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setItem(item: FactView) {
        itemView.apply {
            textFact.text = item.phrase
            textFact.setTextSize(TypedValue.COMPLEX_UNIT_SP, item.itemType.size)
            textCategory.text = item.category
            textCategory.setBackgroundColor(item.color)
        }
    }

    fun clickItem(click: () -> Unit) {
        itemView.shareButton.setOnClickListener {
            click()
        }
    }
}

interface ClickListener {
    fun onClick(item: FactView)
}
