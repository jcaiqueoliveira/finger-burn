package sample.kanda.data.mappers

import kanda.libs.domain.DomainException
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.net.UnknownHostException


/**
 * Created by caique on 3/6/18.
 */
class MapConnectionExceptionsToDomainErrorsTest {

    @Test
    fun `should return the same type of exception received`() {
        val t = RuntimeException()

        assertThat(
                mapConnectionExceptionsToDomainErrors(t))
                .isEqualTo(DomainException.GenericException)
    }

    @Test
    fun `should map the exception received to a domain exception`() {
        val t = UnknownHostException()
        assertThat(
                mapConnectionExceptionsToDomainErrors(t))
                .isEqualTo(DomainException.ClientException)
    }

}