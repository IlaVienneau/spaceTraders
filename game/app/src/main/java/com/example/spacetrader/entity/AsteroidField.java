package com.example.spacetrader.entity;

import java.util.Random;

class AsteroidField {
    private final Player player;
    private final int damageTaken;
    private final double pilotSkillFraction =.05;

    public AsteroidField(Player player) {
        Ship ship = player.getShip();
        this.player = player;
        int currHull = ship.getHullStrength();
        int pilotSkill = player.getPilotSkill();
        Random rand = new Random();
        double damage = Math.abs(rand.nextDouble() - (pilotSkill * pilotSkillFraction));
        int newHull = ((int)((double)currHull * damage));
        ship.setHullStrength(newHull);
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
