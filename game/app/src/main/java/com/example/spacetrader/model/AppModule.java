package com.example.spacetrader.model;

import android.content.Context;
import android.util.Log;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Universe;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    public static class SpaceTraderModel implements Serializable {
        public Player player;
        public Universe universe;
    }

    @Provides @Singleton
    static SpaceTraderModel provideSpaceTraderModel() {
        return new SpaceTraderModel();
    }

    private static String filename = "save.trader";

    public static boolean load(String username, String password,
                               Context context, SpaceTraderModel module) {
        try {
            FileInputStream stream = context.openFileInput(filename);
            ObjectInputStream in = new ObjectInputStream(stream);
            SpaceTraderModel restoredModule = (SpaceTraderModel) in.readObject();
            in.close();

            Player restoredPlayer = restoredModule.player;
            String name = restoredPlayer.getName();

            if ((restoredPlayer != null) && name.equals(username) &&
                    restoredPlayer.isCorrectPassword(password)) {
                module.player = restoredModule.player;
                module.universe = restoredModule.universe;
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            Log.e("AppModule", "Error reading an entry from binary file",e);
            return false;
        } catch (ClassNotFoundException e) {
            Log.e("AppModule", "Error casting a class from the binary file",e);
            return false;
        }
    }

    public static boolean save(Context context, SpaceTraderModel model) {
        try {
            FileOutputStream stream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(stream);
            out.writeObject(model);
            out.close();
        } catch (IOException e) {
            Log.e("AppModule", "Error writing an entry from binary file",e);
            return  false;
        }

        return true;
    }

}
