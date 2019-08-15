package com.coder.weatherforecastapp.data.network;

import com.coder.weatherforecastapp.data.model.Forecast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class WeatherRepository {
    private WeatherNetworkDataSource mDataSource = WeatherNetworkDataSource.getInstance();

    public MutableLiveData<Forecast> getTodaysWeather(String query) {
        return mDataSource.getTodaysWeather(query);
    }
}
