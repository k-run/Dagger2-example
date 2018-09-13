package com.example.karanc.daggerexample.Interfaces;

import com.example.karanc.daggerexample.Modules.RandomUsersModule;
import com.example.karanc.daggerexample.Modules.PicassoModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component(modules = {PicassoModule.class,RandomUsersModule.class})
public interface RandomUserComponent {
    RandomUsersApi getRandomUsersService();
    Picasso getPicasso();
}
