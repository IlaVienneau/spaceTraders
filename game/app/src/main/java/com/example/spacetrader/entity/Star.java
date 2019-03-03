package com.example.spacetrader.entity;

import java.util.ArrayList;

public class Star {

    private String name;
    private StarType starType;

    private int xCord;
    private int yCord;

    private ArrayList<Planet> planets;


    public Star(
            String name, StarType starType, int xCord, int yCord,
            ArrayList<Planet> planets) {
        this.name = name;
        this.starType = starType;

        this.xCord = xCord;
        this. yCord = yCord;

        this.planets = planets;
    }

    public Star(
            String name, StarType starType, int xCord, int yCord) {
        this.name = name;
        this.starType = starType;

        this.xCord = xCord;
        this. yCord = yCord;
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

}