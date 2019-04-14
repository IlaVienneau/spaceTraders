package com.example.spacetrader.entity;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

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

    @NotNull
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Set<TradeGood> keys = inventory.keySet();
        Iterator<TradeGood> goods = keys.iterator();
        while (goods.hasNext()) {
            TradeGood good = goods.next();
            str.append(good.toString());
            if (goods.hasNext()) {
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }

}
