package com.example.spacetrader.entity;

import java.util.Random;

public class AsteroidField {
    Player player;
    int damageTaken;

    public AsteroidField(Player player) {
        this.player = player;
        int currHull = player.getShip().getHullStrength();
        int pilotSkill = player.getPilotSkill();
        Random rand = new Random();
        double damage = Math.abs(rand.nextDouble() - (pilotSkill * .05));
        int newHull = ((int)((double)currHull * damage));
        player.getShip().setHullStrength(newHull);
        this.damageTaken = currHull - newHull;
    }

    /**
     * This method returns the calculated value of damage taken
     * from the asteroid field.
     *
     * @return an int representing damage taken.
     */
    public int getDamageTaken() { return this.damageTaken; }
}
