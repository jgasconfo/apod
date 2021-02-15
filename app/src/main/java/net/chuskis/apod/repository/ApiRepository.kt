package net.chuskis.apod.repository

import net.chuskis.apod.model.responses.Apod
import net.chuskis.apod.network.Resource

interface ApiRepository {

    suspend fun callGetTodayPicture() : Resource<Apod>

    suspend fun callGetRandomPictures(): Resource<List<Apod>>

}