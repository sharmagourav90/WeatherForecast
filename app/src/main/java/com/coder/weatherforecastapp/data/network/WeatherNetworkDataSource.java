package com.coder.weatherforecastapp.data.network;

import android.util.Log;

import com.coder.weatherforecastapp.WeatherApplication;
import com.coder.weatherforecastapp.data.model.Forecast;
import com.coder.weatherforecastapp.util.Constants;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherNetworkDataSource {
    private static final Object LOCK = new Object();
    public static WeatherNetworkDataSource sInstance = null;

    @Inject
    ApixuWeatherApiService apiService;

    public static WeatherNetworkDataSource getInstance() {
        if(sInstance == null) {
            synchronized (LOCK) {
                if(sInstance == null) {
                    sInstance = new WeatherNetworkDataSource();
                    WeatherApplication.getApplication().getApplicationComponent().injectApplication(sInstance);
                }
            }
        }
        return sInstance;
    }

    public MutableLiveData<Forecast> getTodaysWeather(String query) {
        final MutableLiveData<Forecast> forecast = new MutableLiveData<>();

        Call<Forecast> call = apiService.getCurrentWeather(Constants.API_KEY, query);

        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                Log.e("Gourav", "onResponse" + response.body().getCurrent().getCondition().getText());
                forecast.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Log.e("Gourav", "onFailure");
                t.printStackTrace();
                forecast.setValue(null);
            }
        });

        return forecast;
    }
}
