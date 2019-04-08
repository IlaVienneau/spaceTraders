package com.example.spacetrader.entity;
import java.io.Serializable;

class Wormhole implements Serializable {
    private Star startpoint;
    private Star endpoint;
    private int tax;

    public Wormhole(Star s1, Star s2, int t) {
        startpoint = s1;
        endpoint = s2;
        tax = t;


    }

    public void travel() {
        // use to travel from startpoint to endpoint;
    }

}
