package com.coder.weatherforecastapp.data.network;

import com.coder.weatherforecastapp.data.model.Forecast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//http://api.apixu.com/v1/current.json?key=155bb1894f5a4725a9d64412191303&q=London&lang=en

public interface ApixuWeatherApiService {
    @GET("current.json")
    public Call<Forecast> getCurrentWeather(@Query("key") String apiKey, @Query("q") String location);
}
