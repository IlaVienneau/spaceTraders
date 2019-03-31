package com.example.spacetrader.model;

import android.app.Activity;

import com.example.spacetrader.view.ConfigActivity;
import com.example.spacetrader.view.MarketActivity;
import com.example.spacetrader.view.UniverseMapActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class})
public interface AppComponent {
    void inject(ConfigActivity activity);
    void inject(UniverseMapActivity activity);
    void inject(MarketActivity activity);
}
