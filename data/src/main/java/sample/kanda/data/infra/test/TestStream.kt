package sample.kanda.data.infra.test

import io.reactivex.schedulers.TestScheduler
import java.util.concurrent.TimeUnit

/**
 * Created by caique on 3/19/18.
 */

fun TestScheduler.passTime(time: Long) {
    advanceTimeBy(time, TimeUnit.MILLISECONDS)
}