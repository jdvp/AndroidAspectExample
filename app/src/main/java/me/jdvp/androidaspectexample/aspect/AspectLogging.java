package me.jdvp.androidaspectexample.aspect;

import android.view.View;
import android.widget.TextView;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.inject.Inject;

import me.jdvp.androidaspectexample.application.AppComponent;
import me.jdvp.androidaspectexample.application.DaggerSetupApplication;
import me.jdvp.androidaspectexample.viewmodel.LoggingViewModel;

/**
 * Aspect file used to do logging
 *
 * Created by jdvp on 6/29/18.
 */

@Aspect
public class AspectLogging {
    @Inject
    LoggingViewModel loggingViewModel;

    @Pointcut("execution(* me.jdvp.*.activity.*.onCreate(android.os.Bundle))")
    public void onCreate(){}

    @Pointcut("execution(void *.onClick(..))")
    public void onButtonClick() {}

    @Before("onButtonClick() && args(view)")
    public void onClickAdvice(View view) {
        if (loggingInjected() && view instanceof TextView) {
            String text = ((TextView) view).getText().toString();
            loggingViewModel.logItem(text);
        }
    }

    @Before("onCreate()")
    public void onCreateAdvice(JoinPoint joinPoint) {
        if (loggingInjected() && joinPoint != null && joinPoint.getThis() != null) {
            loggingViewModel.logItem("onCreate called in " + joinPoint.getThis().getClass().getSimpleName());
        }
    }

    private boolean loggingInjected() {
        if (loggingViewModel != null) {
            return true;
        }

        AppComponent appComponent = DaggerSetupApplication.getAppComponent();
        if (appComponent != null) {
            appComponent.inject(this);
        }
        return loggingViewModel != null;
    }
}
