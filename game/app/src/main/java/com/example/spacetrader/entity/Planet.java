package com.example.spacetrader.entity;
import java.io.Serializable;
import java.util.HashMap;

import static com.example.spacetrader.entity.RadicalEvent.NONE;

public class Planet implements Serializable {

    private String name;
    private TechLevel techLevel;
    private PoliticalSystem politicalSystem;
    private Resource resource;
    private Star star;
    private boolean visited;
    private RadicalEvent radicalEvent;
    private PlanetInventory inventory;

    /**
     * This constructor makes an instance of a planet with the passed in attributes
     * @param name the name the planet will have
     * @param techLevel the tech level the planet will have
     * @param politicalSystem the type of political system the planet will have
     * @param resource the resources the planet will have
     * @param star the star associated with the planet
     */
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
        this.radicalEvent = NONE;
        this.inventory = new PlanetInventory(techLevel, politicalSystem, resource, radicalEvent);
    }


    /**
     * This method gets the name of the planet
     * @return the name of the planet
     */
    public String getName() {return this.name;}

    /**
     * This method gets the tech level of the planet
     * @return the tech level of the planet
     */
    public TechLevel getTechLevel() {return this.techLevel;}

    /**
     * This method gets the type of political system of the planet
     * @return the political system of the planet
     */
    public PoliticalSystem getPoliticalSystem() {return  this.politicalSystem;}

    /**
     * This method gets the resources on the planet
     * @return the resources on the planet
     */
    public Resource getResource() {return  this.resource;}

    /**
     * This method gets the star associated with the planet
     * @return the star associated with the planet
     */
    public Star getStar() {return this.star;}

    /**
     * This method gets the boolean of if the planet was visited or not yet
     * @return the visited boolean of the planet
     */
    public boolean getVisited() {return this.visited;}


    
    public RadicalEvent getRadicalEvent() {return this.radicalEvent;}

    // Setters

  /**
     * This method sets the visited boolean of the planet to true
     */

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


  
    public void setRadicalEvent(RadicalEvent event) { this.radicalEvent = event;}

  /**
     * This method gets the inventory of the planet
     * @return a hash map containing the trade goods on the planet
     */

    public HashMap<TradeGood, PlanetInventory.TradeStock> getInventory() {
        return inventory.getInventory();
    }

    public PlanetInventory getPlanetInventory() {
        return this.inventory;
    }

/**
     * This method enables the planet to be represented as a string, simply as its name
     * @return the name of the planet
     */
    public String toString() {
        return name;
    }


}
