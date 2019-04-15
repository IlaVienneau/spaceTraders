package com.example.spacetrader.entity;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGetMTLPsTest {
    //ArrayList<TradeGood> expectedArray;

    @Before
    public void setUp() {
        //ArrayList<TradeGood> expectedArray = new ArrayList<TradeGood>();
    }


    @Test
    public void testTechLevel0() {
        List<TradeGood> expectedArray = new ArrayList<TradeGood>();
        expectedArray.add(new TradeGood("water"));
        expectedArray.add(new TradeGood("furs"));
        ArrayList<TradeGood> actualArray = (ArrayList<TradeGood>) TradeGood.getMTLPs(0);
        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void testTechLevel1() {
        List<TradeGood> expectedArray = new ArrayList<TradeGood>();
        expectedArray.add(new TradeGood("water"));
        expectedArray.add(new TradeGood("furs"));
        expectedArray.add(new TradeGood("food"));
        ArrayList<TradeGood> actualArray = (ArrayList<TradeGood>) TradeGood.getMTLPs(1);
        assertEquals(expectedArray, actualArray);

    }

    @Test
    public void testTechLevel2() {
        List<TradeGood> expectedArray = new ArrayList<TradeGood>();
        expectedArray.add(new TradeGood("water"));
        expectedArray.add(new TradeGood("furs"));
        expectedArray.add(new TradeGood("food"));
        expectedArray.add(new TradeGood("ore"));
        ArrayList<TradeGood> actualArray = (ArrayList<TradeGood>) TradeGood.getMTLPs(2);
        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void testTechLevel3() {
        List<TradeGood> expectedArray = new ArrayList<TradeGood>();
        expectedArray.add(new TradeGood("water"));
        expectedArray.add(new TradeGood("furs"));
        expectedArray.add(new TradeGood("food"));
        expectedArray.add(new TradeGood("ore"));
        expectedArray.add(new TradeGood("games"));
        expectedArray.add(new TradeGood("firearms"));
        ArrayList<TradeGood> actualArray = (ArrayList<TradeGood>) TradeGood.getMTLPs(3);
        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void testTechLevel4() {
        List<TradeGood> expectedArray = new ArrayList<TradeGood>();
        expectedArray.add(new TradeGood("water"));
        expectedArray.add(new TradeGood("furs"));
        expectedArray.add(new TradeGood("food"));
        expectedArray.add(new TradeGood("ore"));
        expectedArray.add(new TradeGood("games"));
        expectedArray.add(new TradeGood("firearms"));
        expectedArray.add(new TradeGood("medicines"));
        expectedArray.add(new TradeGood("machines"));
        ArrayList<TradeGood> actualArray = (ArrayList<TradeGood>) TradeGood.getMTLPs(4);
        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void testTechLevel5() {
        List<TradeGood> expectedArray = new ArrayList<TradeGood>();
        expectedArray.add(new TradeGood("water"));
        expectedArray.add(new TradeGood("furs"));
        expectedArray.add(new TradeGood("food"));
        expectedArray.add(new TradeGood("ore"));
        expectedArray.add(new TradeGood("games"));
        expectedArray.add(new TradeGood("firearms"));
        expectedArray.add(new TradeGood("medicines"));
        expectedArray.add(new TradeGood("machines"));
        expectedArray.add(new TradeGood("narcotics"));
        ArrayList<TradeGood> actualArray = (ArrayList<TradeGood>) TradeGood.getMTLPs(5);
        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void testTechLevel6() {
        List<TradeGood> expectedArray = new ArrayList<TradeGood>();
        expectedArray.add(new TradeGood("water"));
        expectedArray.add(new TradeGood("furs"));
        expectedArray.add(new TradeGood("food"));
        expectedArray.add(new TradeGood("ore"));
        expectedArray.add(new TradeGood("games"));
        expectedArray.add(new TradeGood("firearms"));
        expectedArray.add(new TradeGood("medicines"));
        expectedArray.add(new TradeGood("machines"));
        expectedArray.add(new TradeGood("narcotics"));
        expectedArray.add(new TradeGood("robots"));
        ArrayList<TradeGood> actualArray = (ArrayList<TradeGood>) TradeGood.getMTLPs(6);
        assertEquals(expectedArray, actualArray);
    }
}