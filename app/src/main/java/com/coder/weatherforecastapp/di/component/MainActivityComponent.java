package com.coder.weatherforecastapp.di.component;

import android.content.Context;

import com.coder.weatherforecastapp.di.module.RepositoryModule;
import com.coder.weatherforecastapp.di.qualifier.ActivityContext;
import com.coder.weatherforecastapp.di.scopes.ActivityScope;
import com.coder.weatherforecastapp.ui.MainActivity;
import com.coder.weatherforecastapp.ui.weather.current.CurrentWeatherFragment;
import com.coder.weatherforecastapp.ui.weather.current.CurrentWeatherViewModel;

import dagger.Component;
import dagger.Provides;

@ActivityScope
@Component(modules= RepositoryModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();

    void injectMainActivity(CurrentWeatherFragment fragment);
}
