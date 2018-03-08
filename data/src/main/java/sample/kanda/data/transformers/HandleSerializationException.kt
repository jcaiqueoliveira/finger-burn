package sample.kanda.data.transformers

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import sample.kanda.data.mappers.mapGsonErrorToDomainError

/**
 * Created by caique on 3/6/18.
 */
class HandleSerializationException : ObservableTransformer<Any, Any> {

    override fun apply(upstream: Observable<Any>): ObservableSource<Any> {
        return upstream
                .onErrorResumeNext { it: Throwable -> Observable.error(mapGsonErrorToDomainError(it)) }
    }

}