package com.example.spacetrader.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class PlanetInventory extends Inventory {

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
            case HITECH:
                arr = TradeGood.getMTLPs(TechLevel.HITECH.ordinal());
                break;
        }
        for (TradeGood t: arr) {
            inventory.put(t.getName(), t);
        }



    }
}
