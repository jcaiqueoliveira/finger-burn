package sample.kanda.burn.util

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

infix fun MockWebServer.shouldReturn(block: () -> MockResponse) {
    enqueue(block())
}

fun response() = MockResponse()

infix fun MockResponse.with(code: Int): MockResponse {
    setResponseCode(code)
    return this
}

infix fun MockResponse.andBody(body: String): MockResponse {
    setBody(body)
    return this
}





