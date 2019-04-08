package com.example.spacetrader.entity;
import java.io.Serializable;

public class Ship implements Serializable {
    private ShipType type;
    private int maxCapacity;
    private int fuel; //in parsecs/tank
    private int currCapacity;
    private int currFuel;
    private int hullStrength;
    private int maxHullStrength;

    public Ship(){
        this(ShipType.GNAT);
    }

    public Ship(ShipType type) {
        this.type = type;
        switch(type) {
            case FLEA:
                maxCapacity = 0;   //not sure how many it actually has, just says few in centre
                currCapacity = 0;
                fuel = 20;
                currFuel = 20;
                break;
            case GNAT:
                maxCapacity = 15;
                fuel = 14;
                currCapacity = 15;
                currFuel = 14;
                break;
            case WASP:
                maxCapacity = 35;
                fuel = 14;
                currCapacity = 35;
                currFuel = 14;
                break;
            case BEETLE:
                maxCapacity = 50;
                fuel = 14;
                currCapacity = 50;
                currFuel = 14;
                break;
            case HORNET:
                maxCapacity = 20;
                fuel = 16;
                currCapacity = 20;
                currFuel = 16;
                break;
            case FIREFLY:
                maxCapacity = 20;
                fuel = 17;
                currCapacity = 20;
                currFuel = 17;
                break;
            case TERMITE:
                maxCapacity = 60;
                fuel = 14;
                currCapacity = 60;
                currFuel = 14;
                break;
            case MOSQUITO:
                maxCapacity = 15;
                fuel = 13;
                currCapacity = 15;
                currFuel = 13;
                break;
            case BUMBLEBEE:
                maxCapacity = 20;
                fuel = 15;
                currCapacity = 20;
                currFuel = 15;
                break;
            case GRASSHOPPER:
                maxCapacity = 30;
                fuel = 15;
                currCapacity = 30;
                currFuel = 15;
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
    public int getHullStrength() { return this.hullStrength; }

    /**
     * This method sets the current hull strength after an event
     * in which hull damage is possible.
     *
     * @param hullStrength the new hull strength.
     */
    public void setHullStrength(int hullStrength) { this.hullStrength = hullStrength; }

    /**
     * This method returns the max hull strength for the current
     * ship type.
     *
     * @return the max hull strength.
     */
    public int getMaxHullStrength() { return this.maxHullStrength; }

}

