package sample.kanda.data.infra.test

import kanda.libs.domain.ChuckNorrisFact
import retrofit2.Response

/**
 * Created by caique on 3/13/18.
 */

object ResponseFact {

    fun getACorrectFactResponse(): Response<ChuckNorrisFact> {
        return Response.success(ChuckNorrisFact(
                iconUrl = "",
                url = "",
                category = "",
                phrase = ""))
    }


    fun getAnEmptyResponse(): Response<ChuckNorrisFact> {
        return Response.success(null)
    }
}