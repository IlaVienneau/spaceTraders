package com.example.spacetrader.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Random;

public class PlanetInventory implements Serializable {
    public class TradeStock implements Serializable{
        public int quantity;
        public int price;
    }

    private HashMap<TradeGood, TradeStock> inventory;
    private TechLevel techLevel;

    /**
    * creates inventory of trade goods for this planet based on technology level. It creates 10 of
     * each relevant trade goodo and updates the price.
     *
     * @param TechLevel tech: the TechLevel of this planet.
     */
    public PlanetInventory(TechLevel tech) {
        this.inventory = new HashMap<>();
        this.techLevel = tech;

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

        for (TradeGood t : arr) {
            TradeStock stock = new TradeStock();
            stock.price = 0;
            stock.quantity = 10;

            inventory.put(t, stock);
        }

        updatePrices();
    }

    /**
     *  updates the price of all trade goods in this planet's inventory
     *
     */
    public void updatePrices() {
        Random rand = new Random();
        for (TradeGood good : inventory.keySet()) {
            TradeStock stock = inventory.get(good);

            int price = good.getBasePrice()
                    + (good.getIpl() * (techLevel.ordinal() - good.getMtlp()));

            int var = rand.nextInt(good.getVar() + 1);
            if (rand.nextInt(2) == 0) {
                var *= -1;
            }

            price += var;
            stock.price = price;
        }
    }

    /**
     * Gets a HashMap containing the planet's tradegoods and number of each.
     *
     * @return HashMap<TradeGood, TradeStock> containing type and number of tradegoods this planet
     * has in its inventory
     */
    public HashMap<TradeGood, TradeStock> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        String str = "";
        for (TradeGood trade : inventory.keySet()) {
            str += trade.toString();
        }

        return str;
    }
}
