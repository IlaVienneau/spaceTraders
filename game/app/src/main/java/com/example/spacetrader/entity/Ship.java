package com.example.spacetrader.entity;

public class Ship {
    private ShipType type;
    private int capacity;
    private int fuel; //in parsecs/tank

    public Ship(){
        new Ship(ShipType.GNAT);
    }

    public Ship(ShipType type) {
        this.type = type;
        switch(type) {
            case FLEA:
                capacity = 0;   //not sure how many it actually has, just says few in centre
                fuel = 20;
                break;
            case GNAT:
                capacity = 15;
                fuel = 14;
                break;
            case WASP:
                capacity = 35;
                fuel = 14;
                break;
            case BEETLE:
                capacity = 50;
                fuel = 14;
                break;
            case HORNET:
                capacity = 20;
                fuel = 16;
                break;
            case FIREFLY:
                capacity = 20;
                fuel = 17;
                break;
            case TERMITE:
                capacity = 60;
                fuel = 14;
                break;
            case MOSQUITO:
                capacity = 15;
                fuel = 13;
                break;
            case BUMBLEBEE:
                capacity = 20;
                fuel = 15;
                break;
            case GRASSHOPPER:
                capacity = 30;
                fuel = 15;
        }
    }

    public int getCapacity() {return capacity;}

    public int getFuel() {return fuel;}

}

