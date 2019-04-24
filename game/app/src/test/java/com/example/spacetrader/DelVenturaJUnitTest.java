package com.example.spacetrader;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.ShipInventory;
import com.example.spacetrader.entity.ShipType;
import com.example.spacetrader.entity.TradeGood;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class DelVenturaJUnitTest {
    private static final int TIMEOUT = 200;

    private Player testPlayer;


    @Before
    public void setUp() {
        testPlayer = new Player("Fezzik", "password", ShipType.GNAT, 4, 4, 4,4);
    }

    @Test(timeout = TIMEOUT)
    public void testToString() {
        ShipInventory testInventory = new ShipInventory(testPlayer.getShipInventory());

        TradeGood water = new TradeGood("water");
        TradeGood furs = new TradeGood("furs");
        TradeGood narcotics = new TradeGood("narcotics");
        TradeGood food = new TradeGood("food");

        testPlayer.getShipInventory().put(water, 3);
        testPlayer.getShipInventory().put(furs, 1);
        testPlayer.getShipInventory().put(narcotics, 1);
        testPlayer.getShipInventory().put(furs, 1);
        testPlayer.getShipInventory().put(food, 1);

        Map<TradeGood, Integer> expected = new HashMap<>();
        expected.put(water, 3);
        expected.put(furs, 2);
        expected.put(narcotics, 1);
        expected.put(food, 1);

        StringBuilder expectedString = new StringBuilder();

        for (Map.Entry<TradeGood, Integer> g: expected.entrySet()) {
            TradeGood good = g.getKey();
            expectedString.append(good + " ");
        }


        Assert.assertEquals(expectedString.toString(), testInventory.toString());
    }
}
