package com.example.spacetrader.entity;

import java.util.HashMap;

public class ShipInventory extends Inventory {
    private int cargo;
    private ShipType type;
    private Ship ship;

    public ShipInventory(ShipType type) {
        this.type = type;
        this.ship = new Ship(type);
        this.inventory = new HashMap<>();
    }

    public void addItem(TradeGood item) {
        if (cargo < ship.getCapacity()) {
            inventory.put(item.getName(), item);
            cargo++;
        }
    }
}
