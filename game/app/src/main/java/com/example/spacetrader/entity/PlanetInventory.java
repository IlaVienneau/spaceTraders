package com.example.spacetrader.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

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

    public HashMap<String, TradeGood> getInventory() {
        return inventory;
    }
}
