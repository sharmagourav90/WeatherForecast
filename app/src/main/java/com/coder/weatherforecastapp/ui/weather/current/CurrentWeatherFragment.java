package com.coder.weatherforecastapp.ui.weather.current;

import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder.weatherforecastapp.R;
import com.coder.weatherforecastapp.WeatherApplication;
import com.coder.weatherforecastapp.data.model.Forecast;
import com.coder.weatherforecastapp.data.network.ApixuWeatherApiService;
import com.coder.weatherforecastapp.data.network.WeatherRepository;
import com.coder.weatherforecastapp.databinding.CurrentWeatherFragmentBinding;
import com.coder.weatherforecastapp.di.component.ApplicationComponent;
import com.coder.weatherforecastapp.di.component.DaggerMainActivityComponent;
import com.coder.weatherforecastapp.di.component.MainActivityComponent;
import com.coder.weatherforecastapp.di.module.MainActivityContextModule;
import com.coder.weatherforecastapp.ui.MainActivity;
import com.coder.weatherforecastapp.util.ViewModelFactory;

import javax.inject.Inject;

public class CurrentWeatherFragment extends Fragment {

    private CurrentWeatherViewModel mViewModel;
    private CurrentWeatherFragmentBinding mBinding;

    MainActivityComponent mainActivityComponent;

    @Inject
    WeatherRepository mWeatherRepository;

    @Inject
    ApixuWeatherApiService mService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ApplicationComponent applicationComponent = WeatherApplication.get(getActivity()).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule((MainActivity) getActivity()))
                .applicationComponent(applicationComponent)
                .build();
        mainActivityComponent.injectMainActivity(this);
        Log.e("Gourav", "Service - " + mService);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.current_weather_fragment, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewModelFactory factory = new ViewModelFactory(mWeatherRepository);
        mViewModel = ViewModelProviders.of(this, factory).get(CurrentWeatherViewModel.class);
        mBinding.setViewModel(mViewModel);
        mBinding.setLifecycleOwner(this);
        mViewModel.setLoading(true);
        mViewModel.getTodaysWeather("Noida").observe(getActivity(), new Observer<Forecast>() {
            @Override
            public void onChanged(Forecast forecast) {
                if(forecast != null) {
                    mViewModel.setLoading(false);
                    mViewModel.setForecast(forecast);
                }
            }
        });
    }

}
