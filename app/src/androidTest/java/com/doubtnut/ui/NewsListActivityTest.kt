package com.doubtnut.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.doubtnut.R
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class NewsListActivityTest {
     @get:Rule
     val mNewsActivityTestRule = ActivityTestRule(NewsListActivity::class.java)
     private lateinit var mNewsActivity:NewsListActivity

    @Before
    fun setUp() {
        mNewsActivity=mNewsActivityTestRule.activity
    }

    @Test
    fun newsListScroll() {
        Thread.sleep(4000)
        testMultipleTimes(2)
        testMultipleTimes(5)
    }

    private fun testMultipleTimes(position: Int) {
        onView(withId(R.id.rv_news_list)).perform(actionOnItemAtPosition<NewsListAdapter.ViewHolder>(position,click()))
        Thread.sleep(3000)

        onView(withId(R.id.btnBack)).perform(click())
        Thread.sleep(2000)
    }

}