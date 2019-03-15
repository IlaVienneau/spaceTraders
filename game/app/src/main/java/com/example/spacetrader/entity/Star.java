package com.example.spacetrader.entity;

import java.util.HashMap;

public class Star {

    private String name;
    private StarType starType;
    private Resource resourceType;
    private TechLevel techType;

    private int xCord;
    private int yCord;

    private HashMap<String, Planet> planets;


    public Star(
            String name, StarType starType, int x, int y,
            HashMap<String, Planet> planets) {
        this.name = name;
        this.starType = starType;

        this.xCord = x;
        this.yCord =  y;

        this.planets = planets;
    }

    public Star(
            String name, StarType starType, int x, int y, Resource res, TechLevel lev) {
        this.name = name;
        this.starType = starType;

        this.xCord = x;
        this.yCord =  y;
        this.techType = lev;
        this.resourceType = res;

        //create planets.
    }


    // Getters
    public String getName() {
        return name;
    }

    public StarType getStarType() {
        return starType;
    }

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public HashMap<String, Planet> getPlanets() {
        return planets;
    }

    // Setters
    public void setPlanets(HashMap<String, Planet> planets) {
        this.planets = planets;
    }

    public String toString() {
        return "Name:  " + name + ";  Coordinates:  (" + xCord + "," + yCord + ")" +
                "  Star Type:  "+ starType + "  Tech Level:  " + techType + "  Resource Level:  " + resourceType;
    }

    public void addPlanet(Planet plan) {
        planets.put(plan.getName(), plan);
    }

    public Planet getPlanet(String name) {
        return planets.get(name);
    }
}
