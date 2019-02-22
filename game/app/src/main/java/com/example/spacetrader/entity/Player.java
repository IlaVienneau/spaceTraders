package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Player implements Serializable {

    private int id;

    private String name;

    private Ship ship;

    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;

    private Difficulty difficulty;

    public Player(String name, Ship ship, int pilotSkill, int fighterSkill,
                  int traderSkill, int engineerSkill, Difficulty difficulty) {
        this.name = name;
        this.ship = ship;
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.difficulty = difficulty;
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

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String toString() {
        return ("Player Name: " + name + "\n" +
                "Pilot Skill:" + pilotSkill + "\n" +
                "Fighter Skill:" + fighterSkill + "\n" +
                "Trader Skill:" + traderSkill + "\n" +
                "Engineer Skill:" + engineerSkill);
    }
}
