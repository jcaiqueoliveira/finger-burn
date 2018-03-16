package sample.kanda.burn.fact.states

import android.support.test.runner.AndroidJUnit4
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton
import io.reactivex.schedulers.TestScheduler
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import sample.kanda.burn.fact.FactActivity
import sample.kanda.burn.fact.FactNavigator
import sample.kanda.burn.fact.FactRobot
import sample.kanda.burn.util.*
import sample.kanda.data.infra.test.factsResponse
import java.util.concurrent.TimeUnit

/**
 * Created by caique on 3/16/18.
 */
@RunWith(AndroidJUnit4::class)
class SuccessStateTest : ActivityRule<FactActivity>(FactActivity::class.java) {
    val robot = FactRobot()
    val scheduler = TestScheduler()
    val mockWebServer = MockWebServer()

    @Before
    fun setUp() {
        super.beforeTests()
        mockWebServer.start()

        val url = mockWebServer.url("/").toString()

        addModule(Kodein.Module(allowSilentOverride = true) {
            bind<FactNavigator>() with singleton { FactNavigator(scheduler) }
            bind<String>() with singleton { url }
        })
    }

    @Test
    fun shouldReceiveATermAndShowTheResponseCorrectly() {
        mockWebServer shouldReturn { response() withCode 200 andBody factsResponse }

        startActivity()

        robot.apply {
            checkIfWaitingStateIsVisible()
            searchTermsWithText("game")
            scheduler.advanceTimeBy(1000, TimeUnit.MILLISECONDS)
            checkIfSuccessStateIsVisible()
        }
    }

    @After
    fun tearDown() {
        super.afterTests()
        mockWebServer.shutdown()
    }
}