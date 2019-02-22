package com.example.spacetrader.model;

import java.util.List;

import com.example.spacetrader.entity.Player;

public class PlayerInteractor extends Interactor {

    public PlayerInteractor(Repository repo) { super(repo); }

    public List<Player> getAllPlayers() { return getRepository().getAllPlayers(); }

    public void addPlayer(Player s) { getRepository().addPlayer(s); }
}
