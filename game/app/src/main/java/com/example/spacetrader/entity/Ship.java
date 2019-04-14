package com.example.spacetrader.entity;
import java.io.Serializable;

public class Ship implements Serializable {
    private final ShipType type;
    private int maxCapacity;
    private int fuel; //in parsecs/tank
    private int maxHullStrength;
    private int maxWeaponSlots;
    private int maxShieldSlots;
    private int maxGadgetSlots;
    private int maxMercenaryCapacity;

    private int currCapacity;
    private int currFuel; //should update to be the same for all and be the amount of gallons in
    // a tank. this should also change how we calculate having enough fuel to travel to planets
    private int currHullStrength;
    private int currWeaponSlots;
    private int currShieldSlots;
    private int currGadgetSlots;
    private int currMercenaryCapacity;

    private boolean insured;
    private boolean escapePod;



    private static final int weakHull = 1;
    private static final int avgHull = 2;
    private static final int strongHull = 3;

    private static final int fleaHull = weakHull;


    private static final int gnatHull = avgHull;

    private static final int waspHull = strongHull;

    private static final int beetleHull = weakHull;

    private static final int hornetHull = strongHull;

    private static final int fireflyHull = avgHull;

    private static final int termiteHull = strongHull;

    private static final int mosquitoHull = strongHull;

    private static final int bumblebeeHull = avgHull;

    private static final int grasshopperHull = avgHull;

    public Ship(){
        this(ShipType.GNAT);
    }

    public Ship(ShipType type) {
        this.type = type;

        int grasshopperMercenaryCapacity = 2;
        int grasshopperGadgetSlots = 1;
        int grasshopperShieldSlots = 2;
        int grasshopperWeaponSlots = 3;
        int grasshopperFuel = 15;
        int grasshopperCap = 30;
        int bumblebeeMercenaryCapacity = 1;
        int bumblebeeGadgetSlots = 2;
        int bumblebeeShieldSlots = 2;
        int bumblebeeWeaponSlots = 1;
        int bumblebeeFuel = 15;
        int bumblebeeCap = 20;
        int mosquitoMercenaryCapacity = 0;
        int mosquitoGadgetSlots = 1;
        int mosquitoShieldSlots = 1;
        int mosquitoWeaponSlots = 2;
        int mosquitoFuel = 13;
        int mosquitoCap = 15;
        int termiteMercenaryCapacity = 3;
        int termiteGadgetSlots = 2;
        int termiteShieldSlots = 3;
        int termiteWeaponSlots = 1;
        int termiteFuel = 13;
        int termiteCap = 60;
        int fireflyMercenaryCapacity = 0;
        int fireflyGadgetSlots = 1;
        int fireflyShieldSlots = 1;
        int fireflyWeaponSlots = 1;
        int fireflyFuel = 17;
        int fireflyCap = 20;
        int hornetMercenaryCapacity = 2;
        int hornetGadgetSlots = 1;
        int hornetShieldSlots = 2;
        int hornetWeaponSlots = 3;
        int hornetFuel = 16;
        int hornetCap = 20;
        int beetleMercenaryCapacity = 3;
        int beetleGadgetSlots = 1;
        int beetleShieldSlots = 1;
        int beetleWeaponSlots = 0;
        int beetleFuel = 14;
        int beetleCap = 50;
        int waspMercenaryCapacity = 3;
        int waspGadgetSlots = 2;
        int waspShieldSlots = 2;
        int waspWeaponSlots = 3;
        int waspFuel = 14;
        int waspCap = 35;
        int gnatMercenaryCapacity = 0;
        int gnatGadgetSlots = 0;
        int gnatShieldSlots = 1;
        int gnatWeaponSlots = 1;
        int gnatFuel = 14;
        int gnatCap = 15;
        int fleaMercenaryCapacity = 0;
        int fleaGadgetSlots = 0;
        int fleaSheildSlots = 0;
        int fleaWeaponSlots = 0;
        int fleaFuel = 20;
        int fleaCap = 5;
        switch(type) {
            case FLEA:
                maxCapacity = fleaCap;
                fuel = fleaFuel;
                maxHullStrength = fleaHull;
                maxWeaponSlots = fleaWeaponSlots;
                maxShieldSlots = fleaSheildSlots;
                maxGadgetSlots = fleaGadgetSlots;
                maxMercenaryCapacity = fleaMercenaryCapacity;

                currCapacity = 0;
                currFuel = fuel;
                currHullStrength = maxHullStrength;
                currWeaponSlots = 0;
                currShieldSlots = 0;
                currGadgetSlots = 0;
                currMercenaryCapacity = 0;
                break;
            case GNAT:
                maxCapacity = gnatCap;
                fuel = gnatFuel;
                maxHullStrength = gnatHull;
                maxWeaponSlots = gnatWeaponSlots;
                maxShieldSlots = gnatShieldSlots;
                maxGadgetSlots = gnatGadgetSlots;
                maxMercenaryCapacity = gnatMercenaryCapacity;

                currCapacity = 0;
                currFuel = fuel;
                currHullStrength = maxHullStrength;
                currWeaponSlots = 0;
                currShieldSlots = 0;
                currGadgetSlots = 0;
                currMercenaryCapacity = 0;
                break;
            case WASP:
                maxCapacity = waspCap;
                fuel = waspFuel;
                maxHullStrength = waspHull;
                maxWeaponSlots = waspWeaponSlots;
                maxShieldSlots = waspShieldSlots;
                maxGadgetSlots = waspGadgetSlots;
                maxMercenaryCapacity = waspMercenaryCapacity;

                currCapacity = 0;
                currFuel = fuel;
                currHullStrength = maxHullStrength;
                currWeaponSlots = 0;
                currShieldSlots = 0;
                currGadgetSlots = 0;
                currMercenaryCapacity = 0;
                break;
            case BEETLE:
                maxCapacity = beetleCap;
                fuel = beetleFuel;
                maxHullStrength = beetleHull;
                maxWeaponSlots = beetleWeaponSlots;
                maxShieldSlots = beetleShieldSlots;
                maxGadgetSlots = beetleGadgetSlots;
                maxMercenaryCapacity = beetleMercenaryCapacity;

                currCapacity = 0;
                currFuel = fuel;
                currHullStrength = maxHullStrength;
                currWeaponSlots = 0;
                currShieldSlots = 0;
                currGadgetSlots = 0;
                currMercenaryCapacity = 0;
                break;
            case HORNET:
                maxCapacity = hornetCap;
                fuel = hornetFuel;
                maxHullStrength = hornetHull;
                maxWeaponSlots = hornetWeaponSlots;
                maxShieldSlots = hornetShieldSlots;
                maxGadgetSlots = hornetGadgetSlots;
                maxMercenaryCapacity = hornetMercenaryCapacity;

                currCapacity = 0;
                currFuel = fuel;
                currHullStrength = maxHullStrength;
                currWeaponSlots = 0;
                currShieldSlots = 0;
                currGadgetSlots = 0;
                currMercenaryCapacity = 0;
                break;
            case FIREFLY:
                maxCapacity = fireflyCap;
                fuel = fireflyFuel;
                maxHullStrength = fireflyHull;
                maxWeaponSlots = fireflyWeaponSlots;
                maxShieldSlots = fireflyShieldSlots;
                maxGadgetSlots = fireflyGadgetSlots;
                maxMercenaryCapacity = fireflyMercenaryCapacity;

                currCapacity = 0;
                currFuel = fuel;
                currHullStrength = maxHullStrength;
                currWeaponSlots = 0;
                currShieldSlots = 0;
                currGadgetSlots = 0;
                currMercenaryCapacity = 0;
                break;
            case TERMITE:
                maxCapacity = termiteCap;
                fuel = termiteFuel;
                maxHullStrength = termiteHull;
                maxWeaponSlots = termiteWeaponSlots;
                maxShieldSlots = termiteShieldSlots;
                maxGadgetSlots = termiteGadgetSlots;
                maxMercenaryCapacity = termiteMercenaryCapacity;

                currCapacity = 0;
                currFuel = fuel;
                currHullStrength = maxHullStrength;
                currWeaponSlots = 0;
                currShieldSlots = 0;
                currGadgetSlots = 0;
                currMercenaryCapacity = 0;
                break;
            case MOSQUITO:
                maxCapacity = mosquitoCap;
                fuel = mosquitoFuel;
                maxHullStrength = mosquitoHull;
                maxWeaponSlots = mosquitoWeaponSlots;
                maxShieldSlots = mosquitoShieldSlots;
                maxGadgetSlots = mosquitoGadgetSlots;
                maxMercenaryCapacity = mosquitoMercenaryCapacity;

                currCapacity = 0;
                currFuel = fuel;
                currHullStrength = maxHullStrength;
                currWeaponSlots = 0;
                currShieldSlots = 0;
                currGadgetSlots = 0;
                currMercenaryCapacity = 0;
                break;
            case BUMBLEBEE:
                maxCapacity = bumblebeeCap;
                fuel = bumblebeeFuel;
                maxHullStrength = bumblebeeHull;
                maxWeaponSlots = bumblebeeWeaponSlots;
                maxShieldSlots = bumblebeeShieldSlots;
                maxGadgetSlots = bumblebeeGadgetSlots;
                maxMercenaryCapacity = bumblebeeMercenaryCapacity;

                currCapacity = 0;
                currFuel = fuel;
                currHullStrength = maxHullStrength;
                currWeaponSlots = 0;
                currShieldSlots = 0;
                currGadgetSlots = 0;
                currMercenaryCapacity = 0;
                break;
            case GRASSHOPPER:
                maxCapacity = grasshopperCap;
                fuel = grasshopperFuel;
                maxHullStrength = grasshopperHull;
                maxWeaponSlots = grasshopperWeaponSlots;
                maxShieldSlots = grasshopperShieldSlots;
                maxGadgetSlots = grasshopperGadgetSlots;
                maxMercenaryCapacity = grasshopperMercenaryCapacity;

                currCapacity = 0;
                currFuel = fuel;
                currHullStrength = maxHullStrength;
                currWeaponSlots = 0;
                currShieldSlots = 0;
                currGadgetSlots = 0;
                currMercenaryCapacity = 0;
                break;
        }
    }

    /**
     * This method returns the max cargo capacity for the current
     * ship type.
     *
     * @return the max cargo capacity.
     */
    public int getMaxCapacity() {return maxCapacity;}

    /**
     * This method returns the current cargo level.
     *
     * @return the current cargo level.
     */
    public int getCurrCapacity() { return currCapacity;}

    /**
     * This method returns the current level of fuel.
     *
     * @return the current level of fuel.
     */
    public int getCurrFuel() { return currFuel;}

    /**
     * This method is used to set the current level of fuel after
     * travelling to a new planet.
     *
     * @param fuel the new level of fuel.
     */
    public void setCurrFuel(int fuel) {
        this.currFuel = fuel;
    }

    /**
     * This method returns the fuel economy for the current ship
     * type in parsecs/gallon.
     *
     * @return the fuel economy.
     */
    public int getFuel() {return fuel;}

    /**
     * This method returns the current hull strength for the
     * player's ship.
     *
     * @return the current hull strength.
     */
    public int getHullStrength() { return this.currHullStrength; }

    /**
     * This method sets the current hull strength after an event
     * in which hull damage is possible.
     *
     * @param hullStrength the new hull strength.
     */
    public void setHullStrength(int hullStrength) { this.currHullStrength = hullStrength; }

    /**
     * This method returns the max hull strength for the current
     * ship type.
     *
     * @return the max hull strength.
     */
    public int getMaxHullStrength() { return this.maxHullStrength; }

    public int getMaxWeaponSlots() { return  this.maxWeaponSlots; }

    public int getMaxShieldSlots() { return this.maxShieldSlots; }

    public int getMaxGadgetSlots() { return this.maxGadgetSlots; }

    public int getMaxMercenaryCapacity() { return this.maxMercenaryCapacity; }

    public int getCurrHullStrength() { return this.currHullStrength; }

    public int getCurrWeaponSlots() { return  this.currWeaponSlots; }

    public int getCurrShieldSlots() { return this.currShieldSlots; }

    public int getCurrGadgetSlots() { return this.currGadgetSlots; }

    public int getCurrMercenaryCapacity() { return this.currMercenaryCapacity; }

    public boolean getInsured() { return this.insured; }

    public boolean getEscapePod() { return  this.escapePod; }

    public void setCurrHullStrength(int hullStrength) {
        if (hullStrength <= maxHullStrength) {
            this.currHullStrength = hullStrength;
        }
    }

    public void setCurrWeaponSlots(int slots) {
        if (slots <= maxWeaponSlots) {
            this.currWeaponSlots = slots;
        }
    }

    public void setCurrShieldSlots(int slots) {
        if (slots <= maxShieldSlots) {
            this.currShieldSlots = slots;
        }
    }

    public void setCurrGadgetSlots(int slots) {
        if (slots <= maxGadgetSlots) {
            this.currGadgetSlots = slots;
        }
    }

    public void setCurrMercenaryCapacity(int mercs) {
        if (mercs <= maxMercenaryCapacity) {
            this.currMercenaryCapacity = mercs;
        }
    }

    public void setInsured(boolean bool) {
        this.insured = bool;
    }

    public void setEscapePod(boolean bool) {
        this.escapePod = bool;
    }

}

