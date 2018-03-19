package sample.kanda.data.infra.service

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sample.kanda.data.infra.model.ChuckNorrisResponse
import sample.kanda.data.infra.model.ChuckNorrisResult

/**
 * Created by caique on 3/7/18.
 */
interface ChuckNorrisApi {

    @GET("random")
    fun getRandomFact(): Observable<Response<ChuckNorrisResponse>>

    @GET("search")
    fun getFactByTerm(@Query("query") term: String): Observable<Response<ChuckNorrisResult>>

    @GET("category")
    fun getCategories(): Observable<Response<List<String>>>
}