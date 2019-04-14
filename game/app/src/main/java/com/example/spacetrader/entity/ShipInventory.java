package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.HashMap;

public class ShipInventory implements Serializable {

    private final HashMap<TradeGood, Integer> inventory;

    public ShipInventory() {
        this.inventory = new HashMap<>();
    }

    public ShipInventory(HashMap<TradeGood, Integer> inventory) {
        this.inventory = inventory;
    }

    /**
     * This method returns the contents of your ships cargo hold
     * stored in a hash map.
     *
     * @return a hash map of the ship's inventory.
     */
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
