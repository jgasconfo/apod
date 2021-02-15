package net.chuskis.apod.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import net.chuskis.apod.router.MainRouter
import net.chuskis.apod.router.MainRouterImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object RouterModule {

    @Provides
    fun provideRouter(): MainRouter {
        return MainRouterImpl()
    }

}