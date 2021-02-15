package net.chuskis.apod.router

import androidx.fragment.app.FragmentActivity
import net.chuskis.apod.R
import net.chuskis.apod.ui.detail.ApodDetailFragment
import net.chuskis.apod.ui.list.ApodListFragment
import net.chuskis.apod.ui.today.TodayFragment

class MainRouterImpl : MainRouter {

    override fun navigateToApodList(activity: FragmentActivity) {
        activity.supportFragmentManager.beginTransaction().apply {
            val fragment = ApodListFragment()
            replace(R.id.fragment_container, fragment, fragment.javaClass.name)
        }.commit()
    }

    override fun navigateToApodDetail(activity: FragmentActivity) {
        activity.supportFragmentManager.beginTransaction().apply {
            val fragment = ApodDetailFragment()
            addToBackStack(fragment.javaClass.name)
            add(R.id.fragment_container, fragment, fragment.javaClass.name)
        }.commit()
    }

    override fun navigateToTodayApod(activity: FragmentActivity) {
        activity.supportFragmentManager.beginTransaction().apply {
            val fragment = TodayFragment()
            addToBackStack(fragment.javaClass.name)
            add(R.id.fragment_container, fragment, fragment.javaClass.name)
        }.commit()
    }

}