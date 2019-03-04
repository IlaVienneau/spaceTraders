package com.example.spacetrader.entity;

import java.util.ArrayList;

public class Star {

    private String name;
    private StarType starType;
    private Resource resourceType;
    private TechLevel techType;

    private int xCord;
    private int yCord;

    private ArrayList<Planet> planets;


    public Star(
            String name, StarType starType, int x, int y,
            ArrayList<Planet> planets) {
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

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    // Setters
    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public String toString() {
        return "Name:  " + name + ";  Coordinates:  (" + xCord + "," + yCord + ")" +
                "  Star Type:  "+ starType + "  Tech Level:  " + techType + "  Resource Level:  " + resourceType;
    }
}
