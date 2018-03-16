package sample.kanda.data.infra.model

import com.google.gson.annotations.SerializedName

/**
 * Created by caique on 3/7/18.
 */
data class ChuckNorrisResponse(
        @SerializedName("icon_url") val iconUrl: String? = null,
        @SerializedName("id") val id: String? = null,
        @SerializedName("url") val url: String? = null,
        @SerializedName("value") val value: String? = null,
        @SerializedName("category") val category: List<String>? = null)
