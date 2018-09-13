package com.example.karanc.daggerexample.Modules;

import com.example.karanc.daggerexample.Activity.MainActivity;
import com.example.karanc.daggerexample.Adapter.RandomUserAdapter;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

// This is the class for adapter
@Module
public class MainActivityModule {
    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    // This method provides adapter inst
    @Provides
    public RandomUserAdapter randomUserAdapter(Picasso picasso) {
        return new RandomUserAdapter(mainActivity,picasso);
    }
}
