package com.example.spacetrader.model;

import java.util.List;

import com.example.spacetrader.entity.Player;

public class PlayerInteractor extends Interactor {

    public PlayerInteractor(Repository repo) { super(repo); }

    /**
     * This method returns all the players in the repository.
     *
     * @return a list of all players.
     */
    public List<Player> getAllPlayers() {
        Repository repository = getRepository();
        return repository.getAllPlayers();
    }

    /**
     * This method adds a new player to the repository.
     *
     * @param s the new player to add.
     */
    public void addPlayer(Player s) {
        Repository repository = getRepository();
        repository.addPlayer(s); }
}
