package sample.kanda.data.infra.model

import com.google.gson.annotations.SerializedName

/**
 * Created by caique on 3/7/18.
 */
data class ChuckNorrisResponse(
        @SerializedName("icon_url") val iconUrl: String?,
        @SerializedName("id") val id: Int?,
        @SerializedName("url") val url: String?,
        @SerializedName("value") val value: String?)
