package com.example.spacetrader.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Random;

public class PlanetInventory extends Inventory implements Serializable {

    public PlanetInventory (TechLevel tech) {
        this.techLevel = tech;
        this.inventory = new HashMap<>();
        ArrayList<TradeGood> arr = new ArrayList<>();
        switch (tech) {
            case PREAGRICULTURAL:
                arr = TradeGood.getMTLPs(TechLevel.PREAGRICULTURAL.ordinal());
                break;
            case AGRICULTURAL:
                arr = TradeGood.getMTLPs(TechLevel.AGRICULTURAL.ordinal());
                break;
            case MIDIEVAL:
                arr = TradeGood.getMTLPs(TechLevel.MIDIEVAL.ordinal());
                break;
            case RENAISSANCE:
                arr = TradeGood.getMTLPs(TechLevel.RENAISSANCE.ordinal());
                break;
            case EARLYINDUSTRIAL:
                arr = TradeGood.getMTLPs(TechLevel.EARLYINDUSTRIAL.ordinal());
                break;
            case INDUSTRIAL:
                arr = TradeGood.getMTLPs(TechLevel.INDUSTRIAL.ordinal());
                break;
            case POSTINDUSTRIAL:
                arr = TradeGood.getMTLPs(TechLevel.POSTINDUSTRIAL.ordinal());
                break;
            case HITECH:
                arr = TradeGood.getMTLPs(TechLevel.HITECH.ordinal());
                break;
        }
        for (TradeGood t: arr) {
            inventory.put(t.getName(), t);
        }

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
