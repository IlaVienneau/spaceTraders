package com.example.spacetrader.entity;
import java.io.Serializable;

@SuppressWarnings("MagicNumber")
public class Ship implements Serializable {
    private static final int grasshopperFuel = 15;
    private static final int grasshopperCap = 30;
    private static final int bumblebeeFuel = 15;
    private static final int bumblebeeCap = 20;
    private static final int mosquitoFuel = 13;
    private static final int mosquitoCap = 15;
    private static final int termiteFuel = 13;
    private static final int termiteCap = 60;
    private static final int fireflyFuel = 17;
    private static final int fireflyCap = 20;
    private static final int hornetFuel = 16;
    private static final int hornetCap = 20;
    private static final int beetleFuel = 14;
    private static final int beetleCap = 50;
    private static final int waspFuel = 14;
    private static final int waspCap = 35;
    private static final int gnatFuel = 14;
    private static final int gnatCap = 15;
    private static final int fleaFuel = 20;
    private static final int fleaCap = 5;

    private int maxCapacity;
    private int fuel; //in parsecs/tank

    private int currFuel; //should update to be the same for all and be the amount of gallons in

    public Ship(ShipType type) {
        switch(type) {
            case FLEA:
                maxCapacity = fleaCap;
                fuel = fleaFuel;

                currFuel = fuel;
                break;
            case GNAT:
                maxCapacity = gnatCap;
                fuel = gnatFuel;

                currFuel = fuel;
                break;
            case WASP:
                maxCapacity = waspCap;
                fuel = waspFuel;

                currFuel = fuel;
                break;
            case BEETLE:
                maxCapacity = beetleCap;
                fuel = beetleFuel;

                currFuel = fuel;
                break;
            case HORNET:
                maxCapacity = hornetCap;
                fuel = hornetFuel;

                currFuel = fuel;
                break;
            case FIREFLY:
                maxCapacity = fireflyCap;
                fuel = fireflyFuel;

                currFuel = fuel;
                break;
            case TERMITE:
                maxCapacity = termiteCap;
                fuel = termiteFuel;

                currFuel = fuel;
                break;
            case MOSQUITO:
                maxCapacity = mosquitoCap;
                fuel = mosquitoFuel;

                currFuel = fuel;
                break;
            case BUMBLEBEE:
                maxCapacity = bumblebeeCap;
                fuel = bumblebeeFuel;

                currFuel = fuel;
                break;
            case GRASSHOPPER:
                maxCapacity = grasshopperCap;
                fuel = grasshopperFuel;

                currFuel = fuel;
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

