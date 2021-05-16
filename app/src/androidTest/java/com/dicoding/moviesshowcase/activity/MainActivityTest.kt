package com.dicoding.moviesshowcase.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.repo.DataMovies
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest : TestCase(){
    private val mvData = DataMovies.listDataMovies()
    private val tvData = DataMovies.listDataTvs()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testLoadMv() {
        onView(withText("MOVIES")).perform(click())

        onView(withId(R.id.rv_mv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_mv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(mvData.size))
    }

    @Test
    fun testLoadDetailMv() {
        onView(withId(R.id.rv_mv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_mv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(mvData[0].title)))

        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(mvData[0].overview)))

        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(mvData[0].genre)))

        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(withText(mvData[0].release)))

        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(mvData[0].duration)))

        onView(withId(R.id.tv_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_language)).check(matches(withText(mvData[0].language)))

        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText(mvData[0].rating)))

        onView(withId(R.id.bg_top)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun testLoadTv() {
        onView(withText("TV SHOWS")).perform(click())

        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvData.size))
    }

    @Test
    fun testLoadDetailTv() {
        onView(withText("TV SHOWS")).perform(click())

        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(tvData[0].title)))

        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(tvData[0].overview)))

        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(tvData[0].genre)))

        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(withText(tvData[0].release)))

        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(tvData[0].duration)))

        onView(withId(R.id.tv_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_language)).check(matches(withText(tvData[0].language)))

        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText(tvData[0].rating)))

        onView(withId(R.id.bg_top)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()))
    }
}