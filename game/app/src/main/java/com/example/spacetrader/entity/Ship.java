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

    private boolean insured = false;
    private boolean escapePod = false;



    private static int weakHull = 1;
    private static int avgHull = 2;
    private static int strongHull = 3;

    private static int fleaCap = 5;
    private static int fleaFuel = 20;
    private static int fleaHull = weakHull;
    private static int fleaWeaponSlots = 0;
    private static int fleaSheildSlots = 0;
    private static int fleaGadgetSlots = 0;
    private static int fleaMercenaryCapacity = 0;


    private static int gnatCap = 15;
    private static int gnatFuel = 14;
    private static int gnatHull = avgHull;
    private static int gnatWeaponSlots = 1;
    private static int gnatShieldSlots = 1;
    private static int gnatGadgetSlots = 0;
    private static int gnatMercenaryCapacity = 0;

    private static int waspCap = 35;
    private static int waspFuel = 14;
    private static int waspHull = strongHull;
    private static int waspWeaponSlots = 3;
    private static int waspShieldSlots = 2;
    private static int waspGadgetSlots = 2;
    private static int waspMercenaryCapacity = 3;

    private static int beetleCap = 50;
    private static int beetleFuel = 14;
    private static int beetleHull = weakHull;
    private static int beetleWeaponSlots = 0;
    private static int beetleShieldSlots = 1;
    private static int beetleGadgetSlots = 1;
    private static int beetleMercenaryCapacity = 3;

    private static int hornetCap = 20;
    private static int hornetFuel = 16;
    private static int hornetHull = strongHull;
    private static int hornetWeaponSlots = 3;
    private static int hornetShieldSlots = 2;
    private static int hornetGadgetSlots = 1;
    private static int hornetMercenaryCapacity = 2;

    private static int fireflyCap = 20;
    private static int fireflyFuel = 17;
    private static int fireflyHull = avgHull;
    private static int fireflyWeaponSlots = 1;
    private static int fireflyShieldSlots = 1;
    private static int fireflyGadgetSlots = 1;
    private static int fireflyMercenaryCapacity = 0;

    private static int termiteCap = 60;
    private static int termiteFuel = 13;
    private static int termiteHull = strongHull;
    private static int termiteWeaponSlots = 1;
    private static int termiteShieldSlots = 3;
    private static int termiteGadgetSlots = 2;
    private static int termiteMercenaryCapacity = 3;

    private static int mosquitoCap = 15;
    private static int mosquitoFuel = 13;
    private static int mosquitoHull = strongHull;
    private static int mosquitoWeaponSlots = 2;
    private static int mosquitoShieldSlots = 1;
    private static int mosquitoGadgetSlots = 1;
    private static int mosquitoMercenaryCapacity = 0;

    private static int bumblebeeCap = 20;
    private static int bumblebeeFuel = 15;
    private static int bumblebeeHull = avgHull;
    private static int bumblebeeWeaponSlots = 1;
    private static int bumblebeeShieldSlots = 2;
    private static int bumblebeeGadgetSlots = 2;
    private static int bumblebeeMercenaryCapacity = 1;

    private static int grasshopperCap = 30;
    private static int grasshopperFuel = 15;
    private static int grasshopperHull = avgHull;
    private static int grasshopperWeaponSlots = 3;
    private static int grasshopperShieldSlots = 2;
    private static int grasshopperGadgetSlots = 1;
    private static int grasshopperMercenaryCapacity = 2;

    public Ship(){
        this(ShipType.GNAT);
    }

    public Ship(ShipType type) {
        this.type = type;
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

