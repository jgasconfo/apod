package net.chuskis.apod.router

import androidx.fragment.app.FragmentActivity

interface MainRouter {

    fun navigateToApodList(activity: FragmentActivity)

    fun navigateToApodDetail(activity: FragmentActivity)

    fun navigateToTodayApod(activity: FragmentActivity)

}