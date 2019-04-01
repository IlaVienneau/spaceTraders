package com.example.spacetrader.entity;
import java.io.Serializable;

public class Ship {
    private ShipType type;
    private int capacity;
    private int fuel; //in parsecs/tank
    private int currCapacity;
    private int currFuel;

    public Ship(){
        this(ShipType.GNAT);
    }

    public Ship(ShipType type) {
        this.type = type;
        switch(type) {
            case FLEA:
                this.capacity = 0;   //not sure how many it actually has, just says few in centre
                this.currCapacity = 0;
                this.fuel = 20;
                this.currFuel = 20;
                break;
            case GNAT:
                this.capacity = 15;
                this.fuel = 14;
                this.currCapacity = 15;
                this.currFuel = 14;
                break;
            case WASP:
                this.capacity = 35;
                this.fuel = 14;
                this.currCapacity = 35;
                this.currFuel = 14;
                break;
            case BEETLE:
                this.capacity = 50;
                this.fuel = 14;
                this.currCapacity = 50;
                this.currFuel = 14;
                break;
            case HORNET:
                this.capacity = 20;
                this.fuel = 16;
                this.currCapacity = 20;
                this.currFuel = 16;
                break;
            case FIREFLY:
                this.capacity = 20;
                this.fuel = 17;
                this.currCapacity = 20;
                this.currFuel = 17;
                break;
            case TERMITE:
                this.capacity = 60;
                this.fuel = 14;
                this.currCapacity = 60;
                this.currFuel = 14;
                break;
            case MOSQUITO:
                this.capacity = 15;
                this.fuel = 13;
                this.currCapacity = 15;
                this.currFuel = 13;
                break;
            case BUMBLEBEE:
                this.capacity = 20;
                this.fuel = 15;
                this.currCapacity = 20;
                this.currFuel = 15;
                break;
            case GRASSHOPPER:
                this.capacity = 30;
                this.fuel = 15;
                this.currCapacity = 30;
                this.currFuel = 15;
                break;
        }
    }

    public int getCapacity() {return capacity;}

    public int getCurrCapacity() { return currCapacity;}

    public int getCurrFuel() { return currFuel;}

    public int getFuel() {return fuel;}

}

