package com.example.spacetrader.entity;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Star implements Serializable {

    private final String name;
    private final StarType starType;
    private final Resource resourceType;
    private final TechLevel techType;

    private final int xCord;
    private final int yCord;

    private final HashMap<String, Planet> planets;

    /**
     * Constructor for Star
     *  @param name Name of star
     * @param starType type of star
     * @param x x coordinate of star
     * @param y y coordinate of star
     * @param res resource level of star
     * @param lev technology level of star
     */
    public Star(
            String name, StarType starType, int x, int y,
            Resource res, TechLevel lev) {
        this.name = name;
        this.starType = starType;

        this.xCord = x;
        this.yCord =  y;
        this.techType = lev;
        this.resourceType = res;
        this.planets = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            planets.put(name, new Planet(name, techType, resourceType, this));
        }
    }

    // Getters

    /**
     * Gets the name of this star
     *
     * @return String name of star
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type of this star
     *
     * @return type of star
     */
    public StarType getStarType() {
        return starType;
    }

    /**
     *  Gets the x coordinate of the star
     *
     * @return x coordinate of star
     */
    public int getXCord() {
        return xCord;
    }

    /**
     *  Gets the y coordinate of the star
     *
     * @return y coordinate of star
     */
    public int getYCord() {
        return yCord;
    }

    /**
     * Gets an inventory of planets in this solar system
     *
     * @return HashMap of <planet name, planet object> within this solar system
     */
    public Map<String, Planet> getPlanets() {
        return planets;
    }

    // Setters

    @NotNull
    @Override
    public String toString() {
        return "Name:  " + name + ";  Coordinates:  (" + xCord + "," + yCord + ")" +
                "  Star Type:  "+ starType + "  Tech Level:  " + techType
                + "  Resource Level:  " + resourceType;
    }

    /**
     * adds a planet to the star's inventory
     *
     * @param plan the planet to be added.
     */
    public void addPlanet(Planet plan) {
        planets.put(plan.getName(), plan);
    }

    /**
     *  gets the planet object with the name matching the parameter
     *
     * @param name Name of the planet to return
     * @return planet object with the name matching the parameter
     */
    public Planet getPlanet(String name) {
        return planets.get(name);
    }
}
