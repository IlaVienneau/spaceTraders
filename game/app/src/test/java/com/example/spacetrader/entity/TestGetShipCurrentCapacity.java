package com.example.spacetrader.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("MagicNumber")
public class TestGetShipCurrentCapacity {
    private Player actual;

    @Before
    public void setUp() {
        actual = new Player("name", "pass",
                ShipType.GNAT, 16, 0, 0,
                0);
    }

    @Test (expected = NullPointerException.class)
    public void testNullPlayer() {
        Player fake = null;
        fake.getShipCurrentCapacity();
    }

    @Test (expected = NullPointerException.class)
    public void testNullInventory() {
        Player fake = new Player("name", "pass",
                ShipType.GNAT, 16, 0, 0,
                0);
        fake.setShipInventory(null);
        fake.getShipCurrentCapacity();
    }

    @Test
    public void testEmptyCapacity() {
        int test = actual.getShipCurrentCapacity();
        assertEquals(test, 0);
    }

    @Test
    public void testNonEmptyCapacity() {
        actual.getShipInventory().put(new TradeGood("water"), 1);
        int test = actual.getShipCurrentCapacity();
        assertEquals(test, 1);
    }
}
