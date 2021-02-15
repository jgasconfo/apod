package net.chuskis.apod.network

import retrofit2.Response
import java.net.UnknownHostException

abstract class BaseRepository {

    protected suspend fun <T> getNetworkValue(call: suspend () -> Response<T>) : Resource<T> {
        return try {
            val response = call()
            when (response.code()) {
                200, 201 -> {
                    if (response.body() != null) Resource.success(response.body()!!)
                    else Resource.error(null, response.code())
                }
                else -> Resource.error(null, response.code())
            }
        } catch (exception: Exception) {
            return if (exception is UnknownHostException)
                Resource.error(null, -1)
            else
                Resource.error(null, 0)
        }
    }

}