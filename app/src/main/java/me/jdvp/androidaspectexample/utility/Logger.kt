package me.jdvp.androidaspectexample.utility

import android.util.Log

object Logger {
    fun logItem(item: String?) {
        if (!item.isNullOrBlank()) {
            Log.v("LoggingVM", item)

            //usually we might call to a service layer and relay the data to some backend
        }
    }
}