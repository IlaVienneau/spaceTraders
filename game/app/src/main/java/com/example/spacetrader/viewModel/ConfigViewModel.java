package com.example.spacetrader.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.model.Model;
import com.example.spacetrader.model.PlayerInteractor;

public class ConfigViewModel extends AndroidViewModel {
    private PlayerInteractor interactor;

    public ConfigViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    public void addPlayer(Player player) { interactor.addPlayer(player); }
}
