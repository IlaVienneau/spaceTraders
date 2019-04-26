package com.example.spacetrader.entity;

import java.util.Random;

public class PoliceEncounter {
    private int fine;
    private Player player;

    public PoliceEncounter(Player player) {
        this.player = player;
        fine = (int) (player.getWallet() * .15);
    }
    public boolean flee() {
        int wallet = player.getWallet();
        Random rand = new Random();
        int outOf = 10;
        int randomChance = rand.nextInt(100) + 1;
        if (player.getPilotSkill() >= 8) {
            outOf += 20;
        }
        if (player.getPilotSkill() >= 12) {
            outOf += 20;
        }
        if (player.getPilotSkill() >= 16) {
            outOf += 20;
        }

        if (randomChance > outOf) {
            fine = (int) (player.getWallet() * .5);
            return false;
        }
        return true;
    }

    public int getFine() {
        return fine;
    }

    public void pay() {
        int wallet = player.getWallet();
        player.setWallet(wallet - fine);
    }
}
