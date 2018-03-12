package sample.kanda.app.structure

import io.reactivex.Observable
import kanda.libs.domain.DomainException.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Created by caique on 3/9/18.
 */
class HandleStateTest {
    lateinit var exception: Throwable
    val listExceptions = listOf(
            TimeoutException,
            ServerException,
            SerializationException,
            Throwable(),
            RuntimeException())

    @Before
    fun setUp() {
        exception = listExceptions
                .shuffled()
                .take(1)[0]
    }

    @Test
    fun `should map a domain exception to a state correctly`() {

        assertThat(MapErrorToAppState(exception))
                .isInstanceOf(State::class.java)
    }

    @Test
    fun `should receive a response and map to a success state`() {
        val value = "anyString"
        Observable.just(value)
                .compose(HandleState())
                .test()
                .assertComplete()
                .assertResult(SUCCESS(value))
    }

    @Test
    fun `should receive a error and map to a error state`() {
        Observable.error<Throwable>(exception)
                .compose(HandleState())
                .test()
                .assertComplete()
    }

}

