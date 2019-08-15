package com.coder.weatherforecastapp.ui.weather.current;

import android.util.Log;

import com.coder.weatherforecastapp.data.model.Forecast;
import com.coder.weatherforecastapp.data.network.ApixuWeatherApiService;
import com.coder.weatherforecastapp.data.network.WeatherRepository;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CurrentWeatherViewModel extends ViewModel {
    private MutableLiveData<Forecast> forecast = new MutableLiveData<>();
    private WeatherRepository mWeatherRepository = null;

    @Inject
    ApixuWeatherApiService mService;

    public CurrentWeatherViewModel(WeatherRepository weatherRepository) {
        mWeatherRepository = weatherRepository;
    }

    private MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void setLoading(boolean value) {
        this.loading.setValue(value);
    }

    public MutableLiveData<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast.setValue(forecast);
    }

    public LiveData<Forecast> getTodaysWeather(String query) {
        Log.e("Gourav", "Service in VM - " + mService);
        return mWeatherRepository.getTodaysWeather(query);
    }
}
