package com.example.spacetrader.model;

import com.example.spacetrader.view.ConfigActivity;
import com.example.spacetrader.view.LoginActivity;
import com.example.spacetrader.view.MarketActivity;
import com.example.spacetrader.view.PoliceActivity;
import com.example.spacetrader.view.ShipInfoActivity;
import com.example.spacetrader.view.TravelActivity;
import com.example.spacetrader.view.UniverseMapActivity;

import javax.inject.Singleton;

import dagger.Component;

@SuppressWarnings("CyclicClassDependency")
@Singleton
@Component(modules={AppModule.class})
public interface AppComponent {
    void inject(ConfigActivity activity);
    void inject(UniverseMapActivity activity);
    void inject(MarketActivity activity);
    void inject(TravelActivity activity);
    void inject(ShipInfoActivity activity);
    void inject(LoginActivity activity);
    void inject(PoliceActivity activity);

}
