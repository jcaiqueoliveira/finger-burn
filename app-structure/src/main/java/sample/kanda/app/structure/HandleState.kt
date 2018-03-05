package sample.kanda.app.structure

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

class HandleState : ObservableTransformer<Any, State> {
    override fun apply(upstream: Observable<Any>): ObservableSource<State> {
        return upstream
                .map { SUCCESS(it) as State }
                .onErrorResumeNext { error: Throwable ->
                    Observable.just(MapErrorToAppState(error))
                }
    }
}