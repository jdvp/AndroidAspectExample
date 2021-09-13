package me.jdvp.androidaspectexample.utility

import android.util.Log

object Logger {
    fun logItem(item: String?) {
        if (!item.isNullOrBlank()) {
            loggerListeners.forEach { listener -> listener.itemLogged(item) }
            Log.v("LoggingVM", item)

            //usually we might call to a service layer and relay the data to some backend
        }
    }

    //The following is just required for testing since we aren't using DI or anything in this sample
    private val loggerListeners = mutableListOf<LoggerListener>()

    fun registerLoggerListener(listener: LoggerListener) {
        loggerListeners.add(listener)
    }

    fun clearListeners() {
        loggerListeners.clear()
    }

    fun interface LoggerListener {
        fun itemLogged(text: String)
    }
}