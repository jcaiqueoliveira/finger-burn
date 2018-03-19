package sample.kanda.burn.fact.states

import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import sample.kanda.burn.fact.FactActivity
import sample.kanda.burn.fact.FactRobot
import sample.kanda.burn.util.ActivityRule

/**
 * Created by caique on 3/15/18.
 */
@RunWith(AndroidJUnit4::class)
class WaitingStateTest : ActivityRule<FactActivity>(FactActivity::class.java) {

    private val robot = FactRobot()

    @Before
    fun setUp() {
        super.beforeTests()
    }

    @Test
    fun shouldShowWaitingState() {
        launchTest()
        robot.waitingStateIsVisible()
    }

    @After
    fun after() {
        super.afterTests()
    }
}