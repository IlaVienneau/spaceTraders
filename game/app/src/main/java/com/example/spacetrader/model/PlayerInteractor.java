package com.example.spacetrader.model;

import java.util.List;

import com.example.spacetrader.entity.Player;

public class PlayerInteractor extends Interactor {

    public PlayerInteractor(Repository repo) { super(repo); }

    public List<Player> getAllPlayers() {
        Repository repository = getRepository();
        return repository.getAllPlayers();
    }

    public void addPlayer(Player s) {
        Repository repository = getRepository();
        repository.addPlayer(s); }
}
