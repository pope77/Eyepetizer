package com.example.eyepetizer;

import android.app.Application;
import android.widget.Toast;

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

    public void error(int errorCode,String msg){
        Toast.makeText(this,"error"+errorCode,Toast.LENGTH_SHORT).show();
    }

}
