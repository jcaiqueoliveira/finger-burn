package sample.kanda.data.transformers

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import retrofit2.Response
import sample.kanda.data.mappers.mapRestResponse

/**
 * Created by caique on 3/6/18.
 */
class HandleRestResponse : ObservableTransformer<Response<*>, Any> {
    override fun apply(upstream: Observable<Response<*>>): ObservableSource<Any> {
        return upstream
                .map {
                    mapRestResponse(it)
                }
    }
}