package sample.kanda.burn.fact

import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import sample.kanda.burn.util.ActivityRule

/**
 * Created by caique on 3/15/18.
 */
@RunWith(AndroidJUnit4::class)
class FactActivityTest : ActivityRule<FactActivity>(FactActivity::class.java) {

    private val robot = FactRobot()

    @Before
    fun setUp() {
        super.beforeTests()
    }

    @Test
    fun shouldShowWaitingState() {
        startActivity()
        robot.checkIfWaitingStateIsVisible()
    }

    @After
    fun after() {
        super.afterTests()
    }
}