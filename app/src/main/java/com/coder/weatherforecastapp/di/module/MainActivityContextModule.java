package com.coder.weatherforecastapp.di.module;

import android.content.Context;

import com.coder.weatherforecastapp.di.qualifier.ActivityContext;
import com.coder.weatherforecastapp.di.scopes.ActivityScope;
import com.coder.weatherforecastapp.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}
