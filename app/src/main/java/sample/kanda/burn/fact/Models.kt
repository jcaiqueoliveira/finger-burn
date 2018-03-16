package sample.kanda.burn.fact

/**
 * Created by caique on 3/12/18.
 */
data class FactView(
        val color: Int,
        val itemType: ItemViewType,
        val icoUrl: String,
        val url: String,
        val phrase: String,
        val category: String)

sealed class ItemViewType(val size: Float)
object MinTextSize : ItemViewType(12f)
object MaxTextSize : ItemViewType(14f)
