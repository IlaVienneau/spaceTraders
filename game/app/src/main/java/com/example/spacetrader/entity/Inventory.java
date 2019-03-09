package com.example.spacetrader.entity;

import java.util.HashMap;
import java.util.Random;

public abstract class Inventory {
    TechLevel techLevel;
    HashMap<String, TradeGood> inventory;
    public Inventory () {

    }
    public int updatePrice (String good, TechLevel techLevel) {
        Random rand = new Random();
        TradeGood tradeGood = inventory.get(good);
        int price = tradeGood.getBasePrice() + (tradeGood.getIPL() * (techLevel.ordinal() - tradeGood.getMTLP()));
        int var = rand.nextInt(tradeGood.getVariance() + 1);
        if (rand.nextInt(2) == 0) {
            var *= -1;
        }
        price += var;
        return price;
    }
    public void buy (Player player, String good, int quantity) {
        int price = updatePrice(good, this.techLevel);
        price *= quantity;
        updateWallet(player, price);
        
    }
    public void sell (Player player, String good, int quantity) {

    }
    public void updateWallet (Player player, int change) {

    }
}