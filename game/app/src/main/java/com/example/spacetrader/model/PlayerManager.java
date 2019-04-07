package com.example.spacetrader.model;

import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.ShipType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager implements Serializable {
    private final List<Player> players = new ArrayList<>();
    private transient Map<String, Player> playerMap = new HashMap<>();

    // add player to collection
    void addPlayer(String name,
                   String password,
                   ShipType shipType,
                   int pilotSkill,
                   int fighterSkill,
                   int traderSkill,
                   int engineerSkill,
                   Difficulty difficulty) {
        Player player = new Player(name, password, shipType, pilotSkill, fighterSkill, traderSkill, engineerSkill, difficulty);
        players.add(player);
        playerMap.put(name, player);
    }

    Player doLogin(String name, String password) {
        Player player = playerMap.get(name);
        if (player == null) {
            return null;
        }
        if (player.isCorrectPassword(password)) {
            return player;
        }
        return null;
    }

    public List<Player> getPlayers() {
        return players;
    }

    Player getPlayerByName(String name) {
        return playerMap.get(name);
    }


    /**
     * This should only be called during serialization (reading in).
     *
     * This recomputes the student map which is derived from the student collection.
     *
     */
    void regenMap() {
        if (playerMap != null)
            playerMap.clear();
        else
            playerMap = new HashMap<>();
        for (Player p : players) {
            playerMap.put(p.getName(), p);
        }
    }

    /**
     * used by command pattern, should be not called otherwise
     *
     * @param player the student to add
     */
    void addPlayer(Player player) {
        players.add(player);
        playerMap.put(player.getName(), player);
    }

    void removePlayer(Player player) {
        players.remove(player);
        playerMap.remove(player.getName());
    }
}
