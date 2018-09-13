package com.example.karanc.daggerexample.Application;

import android.app.Activity;
import android.app.Application;

import com.example.karanc.daggerexample.Interfaces.RandomUserComponent;
import com.example.karanc.daggerexample.Interfaces.DaggerRandomUserComponent;
import com.example.karanc.daggerexample.Modules.ContextModule;

public class RandomUserApplication extends Application {
    private RandomUserComponent randomUserComponent;

    public static RandomUserApplication get(Activity a) {
        return (RandomUserApplication) a.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        randomUserComponent = DaggerRandomUserComponent.builder().contextModule(new ContextModule(this)).build();
    }

    public RandomUserComponent getRandomUserComponent() {
        return randomUserComponent;
    }
}
