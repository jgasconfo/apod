package net.chuskis.apod.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import net.chuskis.apod.network.ApiService
import net.chuskis.apod.repository.ApiRepository
import net.chuskis.apod.repository.ApiRepositoryImpl

@Module
@InstallIn(ApplicationComponent::class)
object ApiRepositoryModule {

    @Provides
    fun provideApiRepository(api: ApiService): ApiRepository {
        return ApiRepositoryImpl(api)
    }

}