package com.example.spacetrader.entity;

import java.util.HashMap;
import java.util.Random;

public abstract class Inventory {
    TechLevel techLevel;
    HashMap<String, TradeGood> inventory;
    public Inventory (TechLevel tech) {
        this.techLevel = tech;
        this.inventory = new HashMap<>();
        switch (tech) {
            case PREAGRICULTURAL:
                inventory.put("")
                break;
            case AGRICULTURAL:
                break;
            case MIDIEVAL:
                break;
            case RENAISSANCE:
                break;
            case EARLYINDUSTRIAL:
                break;
            case HITECH:
                break;
        }
    }
    public int updatePrice (String good, TechLevel techLevel) {
        Random rand = new Random();
        TradeGood tradeGood = inventory.get(good);
        int price = tradeGood.getPrice() + (tradeGood.getIpl() * (techLevel.ordinal() - tradeGood.getMtlp()));
        //should it be base price? if so make getBasePrice
        int var = rand.nextInt(tradeGood.getVar() + 1);
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
