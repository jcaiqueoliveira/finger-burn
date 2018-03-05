package sample.kanda.data.mappers

import android.util.MalformedJsonException
import kanda.libs.domain.DomainException
import org.assertj.core.api.Assertions
import org.junit.Test

/**
 * Created by caique on 3/6/18.
 */
class MapGsonErrorToDomainDomainExceptionTest {
    @Test
    fun `should return the same type of exception received`() {
        val t = RuntimeException()
        Assertions.assertThat(
                mapGsonErrorToDomainError(t))
                .isEqualTo(t)
    }

    @Test
    fun `should map the exception received to a domain exception`() {
        val t = MalformedJsonException("")
        Assertions.assertThat(
                mapGsonErrorToDomainError(t))
                .isEqualTo(DomainException.SerializationException)
    }
}