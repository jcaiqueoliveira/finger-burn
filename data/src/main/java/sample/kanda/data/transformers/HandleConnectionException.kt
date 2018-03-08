package sample.kanda.data.transformers

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import sample.kanda.data.mappers.mapConnectionExceptionsToDomainErrors

/**
 * Created by caique on 3/6/18.
 */
class HandleConnectionException<T> : ObservableTransformer<Any, T> {
    override fun apply(upstream: Observable<Any>): ObservableSource<T> {
        return upstream
                .map {
                    it as T
                }
                .onErrorResumeNext { it: Throwable ->
                    Observable.error(mapConnectionExceptionsToDomainErrors(it))
                }
    }

}