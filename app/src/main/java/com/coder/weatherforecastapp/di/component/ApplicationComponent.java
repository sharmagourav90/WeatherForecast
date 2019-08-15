package com.coder.weatherforecastapp.di.component;

import android.content.Context;

import com.coder.weatherforecastapp.WeatherApplication;
import com.coder.weatherforecastapp.data.network.ApiClient;
import com.coder.weatherforecastapp.data.network.ApixuWeatherApiService;
import com.coder.weatherforecastapp.data.network.WeatherNetworkDataSource;
import com.coder.weatherforecastapp.di.module.ContextModule;
import com.coder.weatherforecastapp.di.module.RepositoryModule;
import com.coder.weatherforecastapp.di.module.RetrofitModule;
import com.coder.weatherforecastapp.di.qualifier.ApplicationContext;
import com.coder.weatherforecastapp.di.scopes.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    ApixuWeatherApiService getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(WeatherApplication application);

    void injectApplication(WeatherNetworkDataSource application);
}
