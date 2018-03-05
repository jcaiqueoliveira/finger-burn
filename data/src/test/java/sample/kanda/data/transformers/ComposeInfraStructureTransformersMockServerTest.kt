package sample.kanda.data.transformers

import com.google.gson.Gson
import io.reactivex.observers.TestObserver
import kanda.libs.domain.DomainException.ClientException
import kanda.libs.domain.DomainException.ServerException
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import sample.kanda.data.infra.model.ChuckNorrisResponse
import sample.kanda.data.infra.service.Service
import sample.kanda.utils.doARequestAndReturnTimeout
import sample.kanda.utils.doARequestWith
import java.util.concurrent.TimeUnit

/**
 * Created by caique on 3/7/18.
 */
class ComposeInfraStructureTransformersMockServerTest {

    lateinit var mockServer: MockWebServer
    lateinit var api: Service

    @Before
    fun setUp() {
        mockServer = MockWebServer()

    }

    @Test
    fun `should complete without error`() {
        val body = Gson().toJson(ChuckNorrisResponse(null, null, null, null))
        print(body)
        doARequestWith(200, body) {
            getFacts("aaa")
                    .test()
                    .assertComplete()
        }
    }

    @Test
    fun `should receive a 400  and map to domain error`() {

        doARequestWith(400) {
            getFacts("a")
                    .test()
                    .assertError(ClientException)
        }
    }

    @Test
    fun `should receive a serialization error and map to domain error`() {

        doARequestWith(200, "") {
            getFacts("")
                    .test()
                    .assertError(ClientException)
        }
    }

    @Test
    fun `should receive a server error and map to a domain error`() {
        doARequestWith(500) {
            getFacts("aa")
                    .test()
                    .assertError(ServerException)
        }
    }

    @After
    fun shutDown() {
        mockServer.shutdown()
    }
}