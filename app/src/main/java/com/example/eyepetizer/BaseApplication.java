package com.example.eyepetizer;

import android.app.Application;

import com.example.eyepetizer.home.HomeComponent;
import com.example.eyepetizer.home.HomeModule;

/**
 * @author popeg
 */
public class BaseApplication extends Application {

    private AppComponent appComponent;
    private HomeComponent homeComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = createComponent();
    }

    private AppComponent createComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public HomeComponent createHomeComponent(){
        homeComponent = appComponent.plus(new HomeModule());
        return homeComponent;
    }

    public void releaseHomeComponent(){
        homeComponent = null;
    }

    public HomeComponent getHomeComponent(){
        return homeComponent;
    }

}
