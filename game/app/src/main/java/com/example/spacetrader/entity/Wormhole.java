package com.example.spacetrader.entity;
import java.io.Serializable;


class Wormhole implements Serializable {
    private final Star startPoint;
    private final Star endPoint;
    private final int tax;

    public Wormhole(Star s1, Star s2, int t) {
        startPoint = s1;
        endPoint = s2;
        tax = t;


    }

}
