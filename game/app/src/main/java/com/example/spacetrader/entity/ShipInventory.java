package com.example.spacetrader.entity;

import java.util.HashMap;
import java.io.Serializable;

class ShipInventory implements Serializable {

    private HashMap<TradeGood, Integer> inventory;

    public ShipInventory() {
        this.inventory = new HashMap<>();
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
            str += " ";
        }
        return str;
    }

}
