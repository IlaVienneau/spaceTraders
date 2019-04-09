package com.example.spacetrader.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Model;
import com.example.spacetrader.model.PlayerInteractor;

public class ConfigViewModel extends AndroidViewModel {
    private final PlayerInteractor interactor;

    public ConfigViewModel(@NonNull Application application) {
        super(application);
        Model instance = Model.getInstance();
        interactor = instance.getPlayerInteractor();
    }

    public void addPlayer(Player player) { interactor.addPlayer(player); }
}
