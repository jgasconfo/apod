package net.chuskis.apod.repository

import net.chuskis.apod.model.responses.Apod
import net.chuskis.apod.network.ApiService
import net.chuskis.apod.network.BaseRepository
import net.chuskis.apod.network.Resource
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val api: ApiService): BaseRepository(), ApiRepository {

    override suspend fun callGetTodayPicture(): Resource<Apod> =
        getNetworkValue {
            api.callTodayPicture(ApiService.API_KEY)
        }

    override suspend fun callGetRandomPictures(): Resource<List<Apod>> =
        getNetworkValue {
            api.callGetRandomPictures(10, ApiService.API_KEY)
        }

}