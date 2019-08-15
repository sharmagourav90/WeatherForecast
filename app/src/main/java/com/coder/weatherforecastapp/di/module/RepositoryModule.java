package com.coder.weatherforecastapp.di.module;

import com.coder.weatherforecastapp.data.network.WeatherRepository;

import dagger.Module;
import dagger.Provides;

@Module(includes = MainActivityContextModule.class)
public class RepositoryModule {
    @Provides
    WeatherRepository getRepository() {
        return new WeatherRepository();
    }
}
