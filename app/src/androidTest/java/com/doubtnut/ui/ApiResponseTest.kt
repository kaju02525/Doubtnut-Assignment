package com.doubtnut.ui

import androidx.test.rule.ActivityTestRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ApiResponseTest {
    @get:Rule
    val mNewsActivityTestRule = ActivityTestRule(NewsListActivity::class.java)
    private lateinit var mNewsActivity: NewsListActivity

    @Before
    fun setUp() {
        mNewsActivity=mNewsActivityTestRule.activity
    }

    @Test
    fun getNewsData() {
        Thread.sleep(6000)
        val expectedValue=mNewsActivity.newsList[0].author!!
        print("...........$expectedValue")
        Assert.assertEquals("Topdown Charts",expectedValue)
    }

}