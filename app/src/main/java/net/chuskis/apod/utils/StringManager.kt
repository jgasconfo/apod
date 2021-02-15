package net.chuskis.apod.utils

import android.content.Context
import net.chuskis.apod.R

class StringManager(private val context: Context) {

    fun getErrorString(code: Int) : String {
        return when (code) {
            -1 -> context.getString(R.string.no_internet)
            0 -> context.getString(R.string.general_error)
            1 -> context.getString(R.string.empty_email)
            2 -> context.getString(R.string.empty_password)
            401 -> context.getString(R.string.token_expired)
            403 -> context.getString(R.string.invalid_credentials)
            else -> context.getString(R.string.general_error)
        }
    }

}