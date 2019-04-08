package com.example.spacetrader.model;

import java.util.ArrayList;
import java.util.List;

import com.example.spacetrader.entity.Player;

/**
 * This class is an abstraction of the data storage for the business classes
 * Normally this would pass through to our ROOM (database) objects.   To keep this assignment
 * simple, we are just using in-memory storage
 */
class Repository {

    /***
     * This provides a mechanism to generate simple unique numbers to be used as
     * keys in the application
     */
    private static int next_id = 1;

    /**
     * This method returns a new unique integer id.
     *
     * @return the new unique id.
     */
    private static int getNextUniqueID() {
        next_id++;
        return next_id;
    }

    /** all the students known in the application */
    private List<Player> allPlayers;

    /**
     * Make a new Repository object
     */
    public Repository() {
        allPlayers = new ArrayList<>();
    }

    /**
     * get all the players in the system
     * @return list of all players
     */
    public List<Player> getAllPlayers() { return allPlayers;}

    /**
     * add a new player
     * @param player the player to add
     */
    public void addPlayer(Player player) {
        player.setId(Repository.getNextUniqueID());
        allPlayers.add(player);
    }

    /**
     * delete a player
     * @param player the player to delete
     */
    public void deletePlayer(Player player) {
        allPlayers.remove(player);
    }

}
