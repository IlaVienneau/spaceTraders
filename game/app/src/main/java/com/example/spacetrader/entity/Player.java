package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Player implements Serializable {

    private int wallet;
    private int id;

    private String name;
    private final String password;

    private ShipType shipType;
    private final Ship ship;
    private ShipInventory shipInventory;

    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private Planet currPlanet;

    private Difficulty difficulty;

    /**
     * This constructor creates an instance of a player
     * @param name the name the player should have
     * @param password the password associated with the player
     * @param shipType the type of ship the player will have
     * @param pilotSkill the pilot skill level
     * @param fighterSkill the fighter skill level
     * @param traderSkill the trader skill level
     * @param engineerSkill the engineer skill level
     * @param difficulty the difficulty of the game
     */
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

    /**
     * This method sets the id of the player
     * @param id the id the player should have
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method gets the name of the player
     * @return the name of the player
     */
    public String getName() {
        return name;
    }


    /**
     * This method gets the wallet of the player
     * @return the wallet of the player
     */
    public int getWallet() { return this.wallet; }

    /**
     * This method sets the wallet of the player
     * @param wallet the wallet the player should have
     */
    public void setWallet(int wallet) { this.wallet = wallet; }

    /**
     * This method gets the type of ship that the player has
     * @return the type of ship
     */
    public ShipType getShipType() {
        return shipType;
    }

    /**
     * This method gets the ship object of the player
     * @return the ship of the player
     */
    public Ship getShip() { return ship;}

    /**
     * This method gets the current capacity of the player's ship
     * @return the current capacity of the player's ship
     */
    public int getShipCurrentCapacity() {
        int currentCapacity = 0;
        Map<TradeGood, Integer> shipInventory = getShipInventory();

        for (Integer amount : shipInventory.values()) {
            currentCapacity += amount;
        }

        return currentCapacity;
    }

    /**
     * This method gets the player's ship inventory
     * @return the player's ship inventory
     */
    public HashMap<TradeGood, Integer> getShipInventory() {
        return this.shipInventory.getInventory(); }

    /**
     * This method sets the player's ship inventory
     * @param inventory the inventory you want the ship to have
     * @return the player's ship inventory
     */
    public void setShipInventory(ShipInventory inventory) { this.shipInventory = inventory; }

    /**
     * This method sets the current planet to what the player should be on
     * @param planet the planet the player should be on
     */
    public void setCurrPlanet(Planet planet) {
        currPlanet = planet;
    }

    /**
     * This method gets the current planet the player is on
     * @return the current planet the player is on
     */
    public Planet getCurrPlanet() { return currPlanet;}

    /**
     * This methods represents the player as a string
     * @return the player as a string, with its name and skill levels listed
     */
    public String toString() {
        return ("Player Name: " + name + "\n" +
                "Pilot Skill:" + pilotSkill + "\n" +
                "Fighter Skill:" + fighterSkill + "\n" +
                "Trader Skill:" + traderSkill + "\n" +
                "Engineer Skill:" + engineerSkill);
    }

    /**
     * This method checks to see if the password the user entered was correct
     * @param password the password the user entered
     * @return a boolean if the password was correct or not
     */
    public boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * This method gets the pilot skill level of the player
     * @return the pilot skill level of the player
     */
    public int getPilotSkill() {return this.pilotSkill;}

}
