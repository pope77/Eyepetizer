package com.example.eyepetizer.home;

import dagger.Module;
import dagger.Provides;

/**
 * @author popeg
 */
@Module
public class HomeModule {

    @Provides
    HomeInteractor provideHomeInteractor(){
        return new HomeInteractorImpl();
    }

    @Provides
    HomePresenter provideHomePresenter(HomeInteractor interactor){
        return new HomePresenterImpl(interactor);
    }

}
