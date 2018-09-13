package com.example.karanc.daggerexample.Modules;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

// This class provides okHttp dependencies
@Module
public class okHttpClientModule {

    // This method provides okHttp inst
    @Provides
    public OkHttpClient okHttpClient() {
        return new OkHttpClient().newBuilder().build();
    }
}
