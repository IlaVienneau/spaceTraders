package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.HashMap;

public class Player implements Serializable {

    private int wallet;
    private int id;

    private String name;
    private String password;

    private ShipType shipType;
    private Ship ship;
    private ShipInventory shipInventory;

    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private Planet currplanet;

    private Difficulty difficulty;

    public Player(String name, String password,
                  ShipType shipType,
                  int pilotSkill,
                  int fighterSkill,
                  int traderSkill,
                  int engineerSkill,
                  Difficulty difficulty) {
        this.name = name;
        this.password = password;
        this.shipType = shipType;
        this.ship = new Ship(shipType);
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.difficulty = difficulty;
        this.shipInventory = new ShipInventory();
        this.wallet = 1000;
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

    public int getWallet() { return this.wallet; }

    public void setWallet(int wallet) { this.wallet = wallet; }

    public ShipType getShipType() {
        return shipType;
    }

    public Ship getShip() { return ship;}

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public int getShipCurrentCapacity() {
        int currentCapacity = 0;
        Map<TradeGood, Integer> shipInventory = getShipInventory();

        for (Integer amount : shipInventory.values()) {
            currentCapacity += amount;
        }

        return currentCapacity;
    }

    public HashMap<TradeGood, Integer> getShipInventory() { return this.shipInventory.getInventory(); }

    public void setShipInventory(ShipInventory inventory) { this.shipInventory = inventory; }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Planet getPlanet() {return currplanet;}

    public void setCurrplanet(Planet planet) {
        currplanet = planet;
    }

    public Planet getCurrplanet() { return currplanet;}

    public String toString() {
        return ("Player Name: " + name + "\n" +
                "Pilot Skill:" + pilotSkill + "\n" +
                "Fighter Skill:" + fighterSkill + "\n" +
                "Trader Skill:" + traderSkill + "\n" +
                "Engineer Skill:" + engineerSkill);
    }

    public boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }

}
