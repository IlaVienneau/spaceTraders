package com.example.spacetrader.entity;

import java.util.HashMap;
import java.io.Serializable;

public class ShipInventory extends Inventory implements Serializable{
    private int cargo;
    private ShipType type;
    private Ship ship;
    private int wallet;
    private Planet currentplanet;

    public ShipInventory(ShipType type) {
        this.type = type;
        this.ship = new Ship(type);
        this.inventory = new HashMap<>();
        this.wallet = 1000;
        this.currentplanet = Player.getPlanet();
    }

    public void buy(TradeGood item, int num) {
        if (cargo < ship.getCapacity() &&
                currentplanet.getInventory().getInventory().containsKey(item.getName()) &&
                wallet > num*updatePrice(item.getName(), currentplanet.getTechLevel())) {
            if (inventory.containsKey(item.getName())) {
                TradeGood add = inventory.get(item.getName());
                add.setNum(add.getNum() + num);
                inventory.put(item.getName(), item);
            }
            item.setNum(num);
            inventory.put(item.getName(), item);
            cargo += num;
            wallet -= num*updatePrice(item.getName(), currentplanet.getTechLevel());
        }
    }

    public void sell(TradeGood item, int num) {
        if (inventory.containsKey(item.getName()) && inventory.get(item).getNum() >= num){
            TradeGood sell = inventory.get(item.getName());
            sell.setNum(num);
            wallet += num*updatePrice(item.getName(), currentplanet.getTechLevel());
        }
    }

    public HashMap<String, TradeGood> getInventory() {
        return inventory;
    }

}
