package com.example.eyepetizer;

import com.example.eyepetizer.home.HomeComponent;
import com.example.eyepetizer.home.HomeModule;
import com.example.eyepetizer.network.NetWorkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author popeg
 */
@Singleton
@Component(modules = {AppModule.class, NetWorkModule.class})
public interface AppComponent {

    HomeComponent plus(HomeModule homeModule);

}
