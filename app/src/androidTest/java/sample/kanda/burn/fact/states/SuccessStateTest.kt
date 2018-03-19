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
import sample.kanda.data.infra.test.SUCCESS
import sample.kanda.data.infra.test.VALID_BODY
import sample.kanda.data.infra.test.passTime

/**
 * Created by caique on 3/16/18.
 */
@RunWith(AndroidJUnit4::class)
class SuccessStateTest : ActivityRule<FactActivity>(FactActivity::class.java) {
    val robot = FactRobot()
    val timer = TestScheduler()
    val server = MockWebServer()

    @Before
    fun setUp() {
        super.beforeTests()
        server.start()

        val url = server.url("/").toString()

        addModule(Kodein.Module(allowSilentOverride = true) {
            bind<FactNavigator>() with singleton { FactNavigator(timer) }
            bind<String>() with singleton { url }
        })
    }

    @Test
    fun shouldReceiveATermAndShowTheResponseCorrectly() {
        server shouldReturn { response() with SUCCESS andBody VALID_BODY }

        launchTest()

        robot.apply {
            waitingStateIsVisible()
            typeSomeTermToSearch()
            timer.passTime(1000)
            successStateIsVisible()
        }
    }

    @After
    fun tearDown() {
        super.afterTests()
        server.shutdown()
    }
}