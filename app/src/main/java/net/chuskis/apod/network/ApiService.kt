package net.chuskis.apod.network

import net.chuskis.apod.model.responses.Apod
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("apod")
    suspend fun callTodayPicture(@Query("api_key") apiKey: String): Response<Apod>

    @GET("apod")
    suspend fun callGetRandomPictures(@Query("count") count: Int,
                                      @Query("api_key") apiKey: String)
    : Response<List<Apod>>

    companion object {
        const val BASE_URL = "https://api.nasa.gov/planetary/"
        const val API_KEY = "DEMO_KEY" //TODO: get valid api key; remove it from here
    }

}