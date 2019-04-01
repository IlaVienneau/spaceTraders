package com.example.spacetrader.model;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Universe;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    public static class SpaceTraderModel {
        public Player player;
        public Universe universe;
    }

    @Provides @Singleton
    static SpaceTraderModel provideSpaceTraderModel() {
        return new SpaceTraderModel();
    }

}
