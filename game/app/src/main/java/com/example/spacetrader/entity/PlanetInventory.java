package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PlanetInventory implements Serializable {
    public class TradeStock implements Serializable{
        public int quantity;
        public int price;
    }

    private final HashMap<TradeGood, TradeStock> inventory;
    private final TechLevel techLevel;
    private final Resource resource;
    private final RadicalEvent event;

    /**
    * creates inventory of trade goods for this planet based on technology level. It creates 10 of
     * each relevant trade goodo and updates the price.
     *
     * @param tech: the TechLevel of this planet.
     * @param pol: the political system of this planet
     * @param res: the resource level of this planet
     * @param event: the type of radical event that can happen.
     */
    public PlanetInventory(TechLevel tech, PoliticalSystem pol, Resource res, RadicalEvent event) {
        this.inventory = new HashMap<>();
        this.techLevel = tech;
        this.resource = res;
        this.event = event;

        Iterable<TradeGood> arr = TradeGood.getMTLPs(tech.ordinal());
        addToInventory(arr);

        updatePrices();
    }

    private void addToInventory(Iterable<TradeGood> arr) {
        for (TradeGood t : arr) {
            TradeStock stock = new TradeStock();
            stock.price = 0;
            stock.quantity = 10;

            inventory.put(t, stock);
        }
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

            if (good.getIe().equals(this.event)) {
                price *= 5;
            }
            if (good.getCr().equals(this.resource)) {
                price /= 2;
            }
            if (good.getEr().equals(this.resource)) {
                price *= 2;
            }

            price = (int) Math.ceil((double) price);

            if (price <= 0) {
                price = rand.nextInt(10) + 1;
            }

            stock.price = price;
        }
    }

    /**
     * Gets a HashMap containing the planet's TradeGoods and number of each.
     *
     * @return HashMap<TradeGood, TradeStock> containing type and number of TradeGoods this planet
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
