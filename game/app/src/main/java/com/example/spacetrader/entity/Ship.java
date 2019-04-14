package com.example.spacetrader.entity;
import java.io.Serializable;

public class Ship implements Serializable {
    private int maxCapacity;
    private int fuel; //in parsecs/tank
    private int maxHullStrength;

    private int currFuel; //should update to be the same for all and be the amount of gallons in
    // a tank. this should also change how we calculate having enough fuel to travel to planets
    private int currHullStrength;


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

    public Ship(ShipType type) {

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

                currFuel = fuel;
                currHullStrength = maxHullStrength;
                break;
            case GNAT:
                maxCapacity = gnatCap;
                fuel = gnatFuel;
                maxHullStrength = gnatHull;

                currFuel = fuel;
                currHullStrength = maxHullStrength;
                break;
            case WASP:
                maxCapacity = waspCap;
                fuel = waspFuel;
                maxHullStrength = waspHull;

                currFuel = fuel;
                currHullStrength = maxHullStrength;
                break;
            case BEETLE:
                maxCapacity = beetleCap;
                fuel = beetleFuel;
                maxHullStrength = beetleHull;

                currFuel = fuel;
                currHullStrength = maxHullStrength;
                break;
            case HORNET:
                maxCapacity = hornetCap;
                fuel = hornetFuel;
                maxHullStrength = hornetHull;

                currFuel = fuel;
                currHullStrength = maxHullStrength;
                break;
            case FIREFLY:
                maxCapacity = fireflyCap;
                fuel = fireflyFuel;
                maxHullStrength = fireflyHull;

                currFuel = fuel;
                currHullStrength = maxHullStrength;
                break;
            case TERMITE:
                maxCapacity = termiteCap;
                fuel = termiteFuel;
                maxHullStrength = termiteHull;

                currFuel = fuel;
                currHullStrength = maxHullStrength;
                break;
            case MOSQUITO:
                maxCapacity = mosquitoCap;
                fuel = mosquitoFuel;
                maxHullStrength = mosquitoHull;

                currFuel = fuel;
                currHullStrength = maxHullStrength;
                break;
            case BUMBLEBEE:
                maxCapacity = bumblebeeCap;
                fuel = bumblebeeFuel;
                maxHullStrength = bumblebeeHull;

                currFuel = fuel;
                currHullStrength = maxHullStrength;
                break;
            case GRASSHOPPER:
                maxCapacity = grasshopperCap;
                fuel = grasshopperFuel;
                maxHullStrength = grasshopperHull;

                currFuel = fuel;
                currHullStrength = maxHullStrength;
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

}

