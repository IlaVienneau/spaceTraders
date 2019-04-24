package com.example.spacetrader.entity;

import java.util.Random;

public class PoliceEncounter {


    public boolean flee(Player player) {
        Random rand = new Random();
        int randomChance = rand.nextInt(100) + 1;
        if (player.getPilotSkill() > 8) {
            if (randomChance > 30) {
                player.setWallet((int) 0.50*player.getWallet());
                return false;
            }
        }

        else if (randomChance > 10) {
            player.setWallet((int) 0.50*player.getWallet());
            return false;
        }
        return true;
    }

    public void pay(Player player) {
        player.setWallet((int) 0.85*player.getWallet());
    }
}
