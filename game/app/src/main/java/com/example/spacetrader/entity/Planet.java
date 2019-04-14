package com.example.spacetrader.entity;
import java.io.Serializable;
import java.util.HashMap;

import static com.example.spacetrader.entity.RadicalEvent.NONE;

public class Planet implements Serializable {

    private final String name;
    private final TechLevel techLevel;
    private final PoliticalSystem politicalSystem;
    private final Resource resource;
    private final Star star;
    private boolean visited;
    private RadicalEvent radicalEvent;
    private final PlanetInventory inventory;

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
        this.inventory = new PlanetInventory(techLevel, resource, radicalEvent);
    }


    /**
     * This method gets the name of the planet
     * @return the name of the planet
     */
    public String getName() {return this.name;}

    /**
     * This method gets the star associated with the planet
     * @return the star associated with the planet
     */
    public Star getStar() {return this.star;}

    /**
     * This method gets the radical event that occurred
     * @return the type of radical event that occurred
     */
    
    public RadicalEvent getRadicalEvent() {return this.radicalEvent;}

    // Setters

    /**
     * This method sets the type of radical event that should occur
     * @param event the event that should occur
     */
  
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
