package sample.kanda.data.mappers

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kanda.libs.domain.DomainException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.Test
import retrofit2.Response

/**
 * Created by caique on 3/6/18.
 */

class MapRestResponseTest {

    val response: Response<Any> = mock()

    @Test
    fun `should receive an error response and mapper to a client error`() {
        whenever(response.code()).thenReturn(403)

        val thrown = catchThrowable { mapRestResponse(response) }

        assertThat(thrown)
                .isEqualTo(DomainException.ClientException)
    }

    @Test
    fun `should receive an error response and mapper to a server error`() {
        whenever(response.code()).thenReturn(500)

        val thrown = catchThrowable { mapRestResponse(response) }

        assertThat(thrown)
                .isEqualTo(DomainException.ServerException)
    }

    @Test
    fun `should receive a success response and return the body`() {
        val simpleString = "anyString"
        whenever(response.code()).thenReturn(200)
        whenever(response.body()).thenReturn(simpleString)

        assertThat(
                mapRestResponse(response))
                .isEqualTo(simpleString)
    }

    @Test
    fun `should receive a success with empty body and return a Any value`() {

        whenever(response.code()).thenReturn(200)
        whenever(response.body()).thenReturn(null)

        assertThat(
                mapRestResponse(response))
                .isExactlyInstanceOf(Any::class.java)
    }

}