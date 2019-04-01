package com.example.spacetrader.entity;
import java.io.Serializable;

public class Ship implements Serializable {
    private ShipType type;
    private int capacity;
    private int fuel; //in parsecs/tank
    private int currCapacity;
    private int currFuel;

    public Ship(){
        new Ship(ShipType.GNAT);
    }

    public Ship(ShipType type) {
        this.type = type;
        switch(type) {
            case FLEA:
                capacity = 0;   //not sure how many it actually has, just says few in centre
                currCapacity = 0;
                fuel = 20;
                currFuel = 20;
                break;
            case GNAT:
                capacity = 15;
                fuel = 14;
                currCapacity = 15;
                currFuel = 14;
                break;
            case WASP:
                capacity = 35;
                fuel = 14;
                currCapacity = 35;
                currFuel = 14;
                break;
            case BEETLE:
                capacity = 50;
                fuel = 14;
                currCapacity = 50;
                currFuel = 14;
                break;
            case HORNET:
                capacity = 20;
                fuel = 16;
                currCapacity = 20;
                currFuel = 16;
                break;
            case FIREFLY:
                capacity = 20;
                fuel = 17;
                currCapacity = 20;
                currFuel = 17;
                break;
            case TERMITE:
                capacity = 60;
                fuel = 14;
                currCapacity = 60;
                currFuel = 14;
                break;
            case MOSQUITO:
                capacity = 15;
                fuel = 13;
                currCapacity = 15;
                currFuel = 13;
                break;
            case BUMBLEBEE:
                capacity = 20;
                fuel = 15;
                currCapacity = 20;
                currFuel = 15;
                break;
            case GRASSHOPPER:
                capacity = 30;
                fuel = 15;
                currCapacity = 30;
                currFuel = 15;
        }
    }

    public int getCapacity() {return capacity;}

    public int getCurrCapacity() { return currCapacity;}

    public int getCurrFuel() { return currFuel;}

    public int getFuel() {return fuel;}

}

