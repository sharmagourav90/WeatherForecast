package com.coder.weatherforecastapp.util;

import com.coder.weatherforecastapp.data.network.WeatherRepository;
import com.coder.weatherforecastapp.ui.weather.current.CurrentWeatherViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final WeatherRepository mWeatherRepository;

    public ViewModelFactory(WeatherRepository weatherRepository) {
        mWeatherRepository = weatherRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CurrentWeatherViewModel.class)) {
            return (T) new CurrentWeatherViewModel(mWeatherRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
