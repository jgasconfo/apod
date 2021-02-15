package net.chuskis.apod.network

data class Resource<out T>(val status: NetworkStatus, val data: T?, val errorCode: Int?) {
    companion object {
        fun <T> success(data: T): Resource<T> =
            Resource(
                status = NetworkStatus.SUCCESS,
                data = data,
                errorCode = null)
        fun <T> error(data: T?, errorCode: Int): Resource<T> =
            Resource(
                status = NetworkStatus.ERROR,
                data = data,
                errorCode = errorCode)
        fun <T> loading(data: T?): Resource<T> =
            Resource(
                status = NetworkStatus.LOADING,
                data = data,
                errorCode = null)
    }
}