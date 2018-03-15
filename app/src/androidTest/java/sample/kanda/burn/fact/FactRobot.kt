package sample.kanda.burn.fact

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import sample.kanda.burn.R

/**
 * Created by caique on 3/15/18.
 */
class FactRobot {

    fun checkIfWaitingStateIsVisible(): FactRobot {

        onView(withId(R.id.termEntry)).check(matches(isDisplayed()))
        return this
    }
}
