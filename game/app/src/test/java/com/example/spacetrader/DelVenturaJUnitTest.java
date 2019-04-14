package com.example.spacetrader;

import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.ShipInventory;
import com.example.spacetrader.entity.ShipType;
import com.example.spacetrader.entity.TradeGood;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class DelVenturaJUnitTest {
    private static final int TIMEOUT = 200;

    private Player testPlayer;


    @Before
    public void setUp() {
        testPlayer = new Player("Fezzik", "password", ShipType.GNAT, 4, 4, 4,4, Difficulty.BEGINNER);
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

        Assert.assertEquals(expected.keySet().toString(), testInventory.toString());
    }
}
