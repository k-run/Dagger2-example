package com.example.karanc.daggerexample.Modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

//This class provides context
@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context context() {
        return context.getApplicationContext();
    }
}
