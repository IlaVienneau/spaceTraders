package com.example.spacetrader.entity;

import java.util.HashMap;
import java.io.Serializable;
import java.util.Random;

public class ShipInventory implements Serializable {

    private HashMap<TradeGood, Integer> inventory;

    public ShipInventory() {
        this.inventory = new HashMap<>();
    }

    public int currentCapacity() {
        int currentCapacity = 0;
        for (Integer amount : inventory.values()) {
            currentCapacity += amount;
        }

        return currentCapacity;
    }

    public HashMap<TradeGood, Integer> getInventory() {
        return inventory;
    }

    public String toString() {
        String str = "";
        for (TradeGood trade : inventory.keySet()) {
            str += trade.toString();
        }
        return str;
    }

}
