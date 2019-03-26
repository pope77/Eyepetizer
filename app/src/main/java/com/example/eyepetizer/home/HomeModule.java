package com.example.eyepetizer.home;

import com.example.eyepetizer.network.EyepetizerWebService;

import dagger.Module;
import dagger.Provides;

/**
 * @author popeg
 */
@Module
public class HomeModule {

    @Provides
    HomeInteractor provideHomeInteractor(EyepetizerWebService eyepetizerWebService){
        return new HomeInteractorImpl(eyepetizerWebService);
    }

    @Provides
    HomePresenter provideHomePresenter(HomeInteractor interactor){
        return new HomePresenterImpl(interactor);
    }

}
