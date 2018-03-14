package sample.kanda.burn.fact

/**
 * Created by caique on 3/12/18.
 */
data class FactView(
        val color: Int,
        val itemType: ItemViewType,
        val icoUrl: String,
        val url: String,
        val phrase: String)

sealed class ItemViewType
object MinTextSize : ItemViewType()
object MaxTextSize : ItemViewType()
