package sample.kanda.data.transformers

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import retrofit2.Response

/**
 * Created by caique on 3/6/18.
 */
class ComposeInfraStructureTransformers<T> : ObservableTransformer<Response<*>, T> {
    override fun apply(upstream: Observable<Response<*>>): ObservableSource<T> {
        return upstream
                .compose(HandleRestResponse())
                .compose(HandleSerializationException())
                .compose(HandleConnectionException<T>())
    }
}