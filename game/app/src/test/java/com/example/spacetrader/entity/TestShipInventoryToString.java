package com.example.spacetrader.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShipInventoryToString {
    ShipInventory example;

    @Before
    public void setUp() {
        example = new ShipInventory();
    }

    @Test (expected = NullPointerException.class)
    public void testNullShipInventory() throws Exception {
        ShipInventory nill = null;
        nill.toString();
    }

    @Test
    public void testEmptyInventory() {
        ShipInventory empty = new ShipInventory();
        String emptyString = empty.toString();
        assertEquals("", emptyString);
    }

    @Test
    public void testWater() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("water"), 1);
        String trialString = trial.toString();
        assertEquals("water ", trialString);
    }

    @Test
    public void testFurs() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("furs"), 1);
        String trialString = trial.toString();
        assertEquals("furs ", trialString);
    }

    @Test
    public void testFood() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("food"), 1);
        String trialString = trial.toString();
        assertEquals("food ", trialString);
    }

    @Test
    public void testOre() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("ore"), 1);
        String trialString = trial.toString();
        assertEquals("ore ", trialString);
    }

    @Test
    public void testGames() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("games"), 1);
        String trialString = trial.toString();
        assertEquals("games ", trialString);
    }

    @Test
    public void testFirearms() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("firearms"), 1);
        String trialString = trial.toString();
        assertEquals("firearms ", trialString);
    }

    @Test
    public void testMedicine() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("medicine"), 1);
        String trialString = trial.toString();
        assertEquals("medicine ", trialString);
    }

    @Test
    public void testMachines() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("machines"), 1);
        String trialString = trial.toString();
        assertEquals("machines ", trialString);
    }

    @Test
    public void testNarcotics() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("narcotics"), 1);
        String trialString = trial.toString();
        assertEquals("narcotics ", trialString);
    }

    @Test
    public void testRobots() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("robots"), 1);
        String trialString = trial.toString();
        assertEquals("robots ", trialString);
    }

    @Test
    public void testAll() {
        ShipInventory trial = new ShipInventory();
        trial.getInventory().put(new TradeGood("water"), 1);
        trial.getInventory().put(new TradeGood("furs"), 1);
        trial.getInventory().put(new TradeGood("food"), 1);
        trial.getInventory().put(new TradeGood("ore"), 1);
        trial.getInventory().put(new TradeGood("games"), 1);
        trial.getInventory().put(new TradeGood("firearms"), 1);
        trial.getInventory().put(new TradeGood("medicine"), 1);
        trial.getInventory().put(new TradeGood("machines"), 1);
        trial.getInventory().put(new TradeGood("narcotics"), 1);
        trial.getInventory().put(new TradeGood("robots"), 1);
        String trialString = trial.toString();
        assertEquals("furs narcotics ore firearms games medicine machines robots water food ", trialString);
    }

}
