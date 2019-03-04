package com.example.spacetrader.entity;

public class Wormhole {
    Star startpoint;
    Star endpoint;
    int tax;

    public Wormhole(Star s1, Star s2, int t) {
        startpoint = s1;
        endpoint = s2;
        tax = t;


    }

    public void travel() {
        // use to travel from startpoint to endpoint;
    }

}
