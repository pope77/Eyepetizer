package com.example.eyepetizer;

import com.example.eyepetizer.home.HomeComponent;
import com.example.eyepetizer.home.HomeModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author popeg
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    HomeComponent plus(HomeModule homeModule);

}
