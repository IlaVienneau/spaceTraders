package com.example.spacetrader.entity;
import java.io.Serializable;
import java.util.HashMap;

public class Planet implements Serializable {

    private String name;
    private TechLevel techLevel;
    private PoliticalSystem politicalSystem;
    private Resource resource;
    private Star star;
    private boolean visited;
    private PlanetInventory inventory;

    // Constructors
    public Planet(
            String name,
            TechLevel techLevel,
            PoliticalSystem politicalSystem,
            Resource resource,
            Star star) {
        this.name = name;
        this.star = star;
        this.techLevel = techLevel;
        this.politicalSystem = politicalSystem;
        this.resource = resource;
        this.visited = false;
        this.inventory = new PlanetInventory(techLevel);
    }


    // Getters
    public String getName() {return this.name;}

    public TechLevel getTechLevel() {return this.techLevel;}

    public PoliticalSystem getPoliticalSystem() {return  this.politicalSystem;}

    public Resource getResource() {return  this.resource;}

    public Star getStar() {return this.star;}

    public boolean getVisited() {return this.visited;}

    // Setters
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public HashMap<TradeGood, PlanetInventory.TradeStock> getInventory() {
        return inventory.getInventory();
    }

    public String toString() {
        return name;
    }


}
