package sample.kanda.burn.fact

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import sample.kanda.burn.R


/**
 * Created by caique on 3/15/18.
 */
class FactRobot {

    fun waitingStateIsVisible(): FactRobot {

        onView(withId(R.id.termEntry)).check(matches(isDisplayed()))
        return this
    }

    fun typeSomeTermToSearch(term: String = "some string"): FactRobot {

        onView(withId(R.id.termEdtxt)).perform(typeText(term))
        return this
    }

    fun successStateIsVisible(): FactRobot {

        onView(withId(R.id.listFacts)).check(matches(isDisplayed()))
        return this
    }
}
