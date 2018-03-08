package sample.kanda.utils

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import sample.kanda.data.infra.service.ChuckNorrisApi
import sample.kanda.data.infra.service.Service
import java.util.concurrent.TimeUnit

/**
 * Created by caique on 3/7/18.
 */

inline fun doARequestWith(code: Int, body: String = "{}", func: Service.() -> Unit) {
    val server = enqueueResponseToServer(body, code)

    server.start()

    val service = configureService(server.url("/").toString())

    func(service)

    server.shutdown()
}

inline fun doARequestAndReturnTimeout(func: Service.() -> Unit) {
    val server = MockWebServer()

    server.enqueue(MockResponse()
            .setResponseCode(200)
            .setBody("{}")
            .throttleBody(1024, 1, TimeUnit.SECONDS))

    server.start()

    val service = configureService(server.url("/").toString())

    func(service)

    server.shutdown()
}

fun configureService(url: String): Service {
    return Service(api = ServiceBuilderForTest(
            baseUrl = url)
            .create(ChuckNorrisApi::class.java))
}

fun enqueueResponseToServer(body: String, code: Int): MockWebServer {

    val server = MockWebServer()
    server.enqueue(MockResponse()
            .setResponseCode(code)
            .setBody(body))
    return server
}
