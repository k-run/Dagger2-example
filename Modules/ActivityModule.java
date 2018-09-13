package com.example.karanc.daggerexample.Modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    Context context(){
        return  this.context;
    }
}
