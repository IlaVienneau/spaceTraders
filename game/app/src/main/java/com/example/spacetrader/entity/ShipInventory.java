package com.example.spacetrader.entity;

import java.util.HashMap;
import java.io.Serializable;

public class ShipInventory implements Serializable {

    private HashMap<TradeGood, Integer> inventory;

    public ShipInventory() {
        this.inventory = new HashMap<TradeGood, Integer>();
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
