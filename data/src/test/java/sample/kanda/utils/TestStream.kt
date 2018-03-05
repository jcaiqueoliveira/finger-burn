package sample.kanda.utils

import io.reactivex.Observable

/**
 * Created by caique on 3/6/18.
 */

infix fun <T> Observable<T>.shouldCompleteWithError(throwable: Throwable) {
    this.test()
            .assertError(throwable)
}

fun <T> Observable<T>.shouldCompleteWithoutError() {
    this.test()
            .assertComplete()
}