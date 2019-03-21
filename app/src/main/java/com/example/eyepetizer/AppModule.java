package com.example.eyepetizer;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    private Context context;

    AppModule(Application application){
        context = application;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return context;
    }

}
