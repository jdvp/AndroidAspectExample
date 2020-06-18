@file:Suppress("unused")

package me.jdvp.androidaspectexample.aspect

import android.view.View
import android.widget.TextView
import me.jdvp.androidaspectexample.viewmodel.LoggingViewModel
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut


/**
 * Aspect file used to add logging logic at compile time to common actions
 */
@Aspect
class AspectLogging {
    var loggingViewModel: LoggingViewModel? = null

    @Pointcut("execution(* me.jdvp.*.activity.*.onCreate(android.os.Bundle))")
    fun onCreate() {
    }

    @Pointcut("execution(void *.onClick(..))")
    fun onButtonClick() {
    }

    @Before("onButtonClick() && args(view)")
    fun onClickAdvice(view: View?) {
        if (loggingInjected() && view is TextView) {
            val text = view.text.toString()
            loggingViewModel?.logItem(text)
        }
    }

    private fun loggingInjected(): Boolean {
        return true
    }
}