package com.example.eyepetizer.network;

import com.example.eyepetizer.system.Global;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author popeg
 */
@Module
public class NetWorkModule {

    @Singleton
    @Provides
    Retrofit retrofit (){
        return new Retrofit.Builder()
                .baseUrl(Global.API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    EyepetizerWebService eyepetizerWebService(Retrofit retrofit){
        return retrofit.create(EyepetizerWebService.class);
    }

}
