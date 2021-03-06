package com.example.spacetrader.entity;

import java.util.Random;

public class GoblinEncounter {

    public boolean fight(Player player) {
        Random rand = new Random();
        int randomChance = rand.nextInt(100) + 1;
        int outOf = 20;

        if (player.getFighterSkill() > 10) {
            outOf += 10;
        }
        for (int i = player.getShip().getCurrWeaponSlots(); i > 0; i--) {
            outOf += 10;
        }
        for (int i = player.getShip().getCurrShieldSlots(); i > 0; i--) {
            outOf += 10;
        }

        if (randomChance > outOf) {
            player.setWallet(1);
            return false;
        }
        return true;

    }

    public void surrender(Player player) {
        Random rand = new Random();
        int randomChance = rand.nextInt(100) + 1;
        if (randomChance < 5) {
            player.setWallet(2 * player.getWallet());
        } else {
            player.setWallet((int) 0.5*player.getWallet());
        }
    }
}
