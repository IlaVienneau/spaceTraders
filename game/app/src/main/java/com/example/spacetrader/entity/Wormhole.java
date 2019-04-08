package com.example.spacetrader.entity;
import java.io.Serializable;

<<<<<<< HEAD
class Wormhole implements Serializable {
    private Star startpoint;
    private Star endpoint;
=======
public class Wormhole implements Serializable {
    private Star startPoint;
    private Star endPoint;
>>>>>>> master
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
