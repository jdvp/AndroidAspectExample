package me.jdvp.androidaspectexample.viewmodel.impl

import android.util.Log
import me.jdvp.androidaspectexample.viewmodel.LoggingViewModel

internal class LoggingViewModelImpl : LoggingViewModel {
    override fun logItem(item: String?) {
        if (!item.isNullOrBlank()) {
            Log.v("LoggingVM", item)

            //usually we might call to a service layer and relay the data to some backend
        }
    }
}