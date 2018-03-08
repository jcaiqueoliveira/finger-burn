package sample.kanda.data.transformers

import android.util.MalformedJsonException
import com.google.gson.JsonIOException
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import kanda.libs.domain.DomainException
import org.junit.Before
import org.junit.Test
import sample.kanda.data.infra.test.InMemory
import sample.kanda.utils.shouldCompleteWithError
import sample.kanda.utils.shouldCompleteWithoutError
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by caique on 3/6/18.
 */
class ComposeInfraStructureTransformersInMemoryTest {

    lateinit var inMemory: InMemory

    @Before
    fun setUp() {
        inMemory = InMemory()
    }

    @Test
    fun `should complete without error`() {
        inMemory.successState()

        inMemory.getFacts("").shouldCompleteWithoutError()

    }

    @Test
    fun `should finish with error of serialization mapped to domain`() {
        val error = mutableListOf(JsonSyntaxException(""),
                MalformedJsonException(""),
                JsonParseException(""),
                JsonIOException(""))
                .shuffled()
                .take(1)[0]

        inMemory.nextError(error)

        inMemory.getFacts("") shouldCompleteWithError DomainException.SerializationException

    }

    @Test
    fun `should finish with error of Client mapped to domain`() {
        val error = mutableListOf(IOException(),
                UnknownHostException(),
                SocketTimeoutException())
                .shuffled()
                .take(1)[0]

        inMemory.nextError(error)

        inMemory.getFacts("") shouldCompleteWithError DomainException.ClientException

    }


    @Test
    fun `should receive an error and return a generic error`() {
        val error = RuntimeException()

        inMemory.nextError(error)

        inMemory.getFacts("") shouldCompleteWithError DomainException.GenericException
    }

}