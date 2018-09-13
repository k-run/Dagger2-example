package com.example.karanc.daggerexample.Modules;

import android.content.Context;

import com.example.karanc.daggerexample.Modules.ContextModule;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

// This class is the dependency providing class for Picasso

@Module(includes = ContextModule.class)
public class PicassoModule {

    // This method provides a picasso inst
   @Provides
    public Picasso picasso(Context context, OkHttp3Downloader okHttpDownloader) {
       return new Picasso.Builder(context)
               .downloader(okHttpDownloader).build();
   }

   // This method provides an okhttp inst
   @Provides
    public OkHttp3Downloader okHttpDownloader(OkHttpClient okHttpClient) {
       return new OkHttp3Downloader(okHttpClient);
   }
}
