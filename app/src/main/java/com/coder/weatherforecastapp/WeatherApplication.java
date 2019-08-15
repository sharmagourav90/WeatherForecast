package com.coder.weatherforecastapp;

import android.app.Activity;
import android.app.Application;

import com.coder.weatherforecastapp.di.component.ApplicationComponent;
import com.coder.weatherforecastapp.di.component.DaggerApplicationComponent;
import com.coder.weatherforecastapp.di.module.ContextModule;

public class WeatherApplication extends Application {
    ApplicationComponent applicationComponent;

    static WeatherApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);

        application = this;
    }

    public static WeatherApplication get(Activity activity){
        return (WeatherApplication) activity.getApplication();
    }

    public static WeatherApplication getApplication() {
        return application;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
