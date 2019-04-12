package com.example.spacetrader.entity;
import java.io.Serializable;


public class Wormhole implements Serializable {
    private Star startPoint;
    private Star endPoint;
    private int tax;

    public Wormhole(Star s1, Star s2, int t) {
        startPoint = s1;
        endPoint = s2;
        tax = t;


    }

    public void travel() {
        // use to travel from start point to endpoint;
    }

}
