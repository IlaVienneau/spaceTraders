package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Player implements Serializable {

    private int wallet;
    private int id;

    private String name;

    private ShipType ship;
    private ShipInventory shipInventory;

    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private static Planet  currplanet;

    private Difficulty difficulty;

    public Player(String name, ShipType ship, int pilotSkill, int fighterSkill,
                  int traderSkill, int engineerSkill, Difficulty difficulty) {
        this.name = name;
        this.ship = ship;
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.difficulty = difficulty;
        this.shipInventory = new ShipInventory(this.ship);
        this.wallet = 1000;
        System.out.println(toString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWallet() { return this.wallet; };

    public void setWallet(int change) { this.wallet += change; }

    public ShipType getShip() {
        return ship;
    }

    public void setShip(ShipType ship) {
        this.ship = ship;
    }

    public ShipInventory getShipInventory() { return this.shipInventory; }

    public void setShipInventory(ShipInventory inventory) { this.shipInventory = inventory; }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public static Planet getPlanet() {return currplanet;}

    public String toString() {
        return ("Player Name: " + name + "\n" +
                "Pilot Skill:" + pilotSkill + "\n" +
                "Fighter Skill:" + fighterSkill + "\n" +
                "Trader Skill:" + traderSkill + "\n" +
                "Engineer Skill:" + engineerSkill);
    }

    public void setCurrplanet(Planet planet) {
        currplanet = planet;
    }


}
