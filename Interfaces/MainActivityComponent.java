package com.example.karanc.daggerexample.Interfaces;

import com.example.karanc.daggerexample.Activity.MainActivity;
import com.example.karanc.daggerexample.Modules.MainActivityModule;

import dagger.Component;

@Component(modules = MainActivityModule.class, dependencies = RandomUserComponent.class)
public interface MainActivityComponent {
   void inject(MainActivity mainActivity);
}
