@file:Suppress("unused")

package me.jdvp.androidaspectexample.aspect

import android.view.View
import android.widget.TextView
import me.jdvp.androidaspectexample.utility.Logger
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut


/**
 * Aspect file used to add logging logic at compile time to common actions
 */
@Aspect
class AspectLogging {
    /**
     * Indicates that the execution of the onCreate method with a single Bundle argument is
     * called from any class in my Activity package
     */
    @Pointcut("execution(* me.jdvp.*.activity.*.onCreate(android.os.Bundle))")
    fun onCreate() {
    }

    /**
     * Runs the code in this method before the onCreate method gets called.
     *
     * Note that the value in the annotation is the same as the pointcut in this file that I want to use
     */
    @Before("onCreate()")
    fun onCreateAdvice(joinPoint: JoinPoint?) {
        if (joinPoint?.getThis() != null) {
            Logger.logItem("onCreate called in " + joinPoint.getThis().javaClass.simpleName)
        }
    }

    /**
     * Captures the execution of any method named onClick in any class that has a return type of void.
     */
    @Pointcut("execution(void *.onClick(..))")
    fun onButtonClick() {
    }

    /**
     * Runs the code in this method before the onCreate method gets called.
     *
     * The value in the annotation mentions both the pointcut to use and the argument that I want to capture.
     */
    @Before("onButtonClick() && args(view)")
    fun onClickAdvice(view: View?) {
        if (view is TextView) {
            val text = view.text.toString()
            Logger.logItem(text)
        }
    }
}