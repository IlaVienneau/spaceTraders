package com.example.spacetrader.entity;

import java.util.HashMap;
import java.io.Serializable;
import java.util.Random;

public class ShipInventory extends Inventory implements Serializable{
    private int cargo;
    private ShipType type;
    private Ship ship;
    private int wallet;
    private Planet currentplanet;
    private HashMap<String, TradeGood> inventory;

    public ShipInventory(ShipType type) {
        this.type = type;
        this.ship = new Ship(type);
        this.inventory = new HashMap<>();
        this.wallet = 1000;
        this.currentplanet = Player.getPlanet();
    }

    @Override
    public int updatePrice(String good, TechLevel techLevel) {
        Random rand = new Random();
        TradeGood tradeGood = inventory.get(good);
        int price = tradeGood.getPrice() + (tradeGood.getIpl() * (techLevel.ordinal() - tradeGood.getMtlp()));

        int var = rand.nextInt(tradeGood.getVar() + 1);
        if (rand.nextInt(2) == 0) {
            var *= -1;
        }
        price += var;
        return price;
    }

    public void buy(TradeGood item, int num, Planet current_planet) {
        //TradeGood item = current_planet.getInventory().getInventory().get(thisbread);

        System.out.println("Curr planet" + current_planet);
        System.out.println("Curr invent" + current_planet.getInventory());
        System.out.println("Curr tradeGoods" + current_planet.getInventory().getInventory());
        System.out.println("the good: " + item);

        if (cargo < ship.getCapacity() &&
                current_planet.getInventory().getInventory().containsKey(item.getName()) &&
                wallet > num*current_planet.getInventory().updatePrice(item.getName(), current_planet.getTechLevel())) {
            if (inventory.containsKey(item.getName())) {
                TradeGood add = inventory.get(item.getName());
                add.setNum(add.getNum() + 1);
                inventory.put(add.getName(), add);
            } else {
                item.setNum(num);
                inventory.put(item.getName(), item);
            }
            cargo += num;
            wallet -= num*updatePrice(item.getName(), current_planet.getTechLevel());
        }
    }

    public void sell(TradeGood item, int num, Planet current_planet) {
        System.out.println("Trying to sell, curr inventory:  " + inventory);
        if (inventory.containsKey(item.getName())){
            TradeGood sold = inventory.get(item.getName());
            sold.setNum(inventory.get(item.getName()).getNum() - 1);
            if (sold.getNum() <= 0) {
                inventory.remove(item.getName());
            } else {
                inventory.put(sold.getName(), sold);
            }
            wallet += num*current_planet.getInventory().updatePrice(item.getName(), current_planet.getTechLevel());
        }
    }

    public HashMap<String, TradeGood> getInventory() {
        return inventory;
    }

    public String toString() {
        String str = "";
        for (TradeGood trade : inventory.values()) {
            str += trade.toString();
        }
        return str;
    }

}
