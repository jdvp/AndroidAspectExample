package me.jdvp.androidaspectexample.viewmodel.impl;

import android.util.Log;

import me.jdvp.androidaspectexample.viewmodel.LoggingViewModel;

/**
 * Created by jdvp on 6/29/18.
 */

class LoggingViewModelImpl implements LoggingViewModel {
    @Override
    public void logItem(String item) {
        if (item != null && item.length() > 0 && item.trim().length() > 0) {
            Log.v("LoggingVM", item);

            //usually we might call to a service layer and relay the data to some backend
        }
    }
}
