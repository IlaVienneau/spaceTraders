package com.example.spacetrader.entity;

import java.util.Random;

public class PoliceEncounter {

    public void flee(Player player) {
        Random rand = new Random();
        int randomChance = rand.nextInt(100) + 1;
        if (player.getPilotSkill() > 8) {
            if (randomChance > 30) {
                player.setWallet((int) 0.50*player.getWallet());
            }

        }

        else if (randomChance > 10) {
            player.setWallet((int) 0.50*player.getWallet());
        }

    }

    public void pay(Player player) {
        player.setWallet((int) 0.85*player.getWallet());
    }
}
