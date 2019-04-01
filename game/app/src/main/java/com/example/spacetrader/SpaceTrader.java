package com.example.spacetrader;

import android.app.Application;

import com.example.spacetrader.model.AppComponent;
import com.example.spacetrader.model.AppModule;
import com.example.spacetrader.model.DaggerAppComponent;

public class SpaceTrader extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
