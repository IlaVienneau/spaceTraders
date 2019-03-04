package com.example.spacetrader.entity;

import java.util.ArrayList;
import java.util.Random;

public class Star {

    private String name;
    private StarType starType;

    private int xCord;
    private int yCord;

    private ArrayList<Planet> planets;


    public Star(
            String name, StarType starType, int row, int col,
            ArrayList<Planet> planets) {
        Random rand = new Random();
        int num = rand.nextInt(9);

        this.name = name;
        this.starType = starType;

        this.xCord = col + num % 3;
        this.yCord =  row + (int) java.lang.Math.floor(num/3);

        this.planets = planets;
    }

    public Star(
            String name, StarType starType, int row, int col) {
        Random rand = new Random();
        int num = rand.nextInt(9);

        this.name = name;
        this.starType = starType;

        this.xCord = col + num % 3;
        this.yCord =  row + (int) java.lang.Math.floor(num/3);

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

}
