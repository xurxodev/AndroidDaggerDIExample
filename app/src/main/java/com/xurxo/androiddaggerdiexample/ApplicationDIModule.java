package com.xurxo.androiddaggerdiexample;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = MainActivity.class)
public class ApplicationDIModule {

    @Provides
    @Singleton
    public RestCountriesClient providesRestCountriesClient() {
        return new DefaultRestCountriesClient();
    }
}
