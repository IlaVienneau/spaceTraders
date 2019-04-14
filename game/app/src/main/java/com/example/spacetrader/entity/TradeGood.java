package com.example.spacetrader.entity;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class TradeGood implements Serializable {
    private String name;    // trade good name
    private String type;    // natural or industrial
    private int mtlp;       // minimum tech level to produce
    private int mtlu;       // minimum tech level to use
    private int ttp;        // tech level that produces the most of this item
    private int ipl;        // price increase per tech level

    private int var;        // variance ( maximum percentage that the price can vary above or below the base)
    private RadicalEvent ie;// Radical price increase event, when this even happens on a planet, the price may increase astronomically
    @Nullable
    private Resource cr;    // When this condition is present, the price of this resource is unusually low
    @Nullable

    private Resource er;    // When this condition is present, the resource is expensive
    private int mtl;        // Min price offered in space trade with random trader (not on a planet)
    private int mth;        // Max price offered in space trade with random trader (not on a planet)
    private int basePrice;  //

    //tech level increases -> $ natural goods increases
    //tech level increases -> $ industrial goods decreases

    @SuppressWarnings("MagicNumber")
    public TradeGood(String name) {
        this.name = name;
        switch (name) {
            case "water":
                type      = "natural";
                mtlp      = 0;
                mtlu      = 0;
                ttp       = 2;
                basePrice = 30;
                ipl       = 3;
                var       = 4;
                ie        = RadicalEvent.DROUGHT;
                cr        = Resource.LOTSOFWATER;
                er        = Resource.DESERT;
                mtl       = 30;
                mth       = 50;
                break;
            case "furs":
                type      = "natural";
                mtlp      = 0;
                mtlu      = 0;
                ttp       = 0;
                basePrice = 250;
                ipl       = 10;
                var       = 10;
                ie        = RadicalEvent.COLD;
                cr        = Resource.RICHFAUNA;
                er        = Resource.LIFELESS;
                mtl       = 230;
                mth       = 280;
                break;
            case "food":
                type      = "natural";
                mtlp      = 1;
                mtlu      = 0;
                ttp       = 1;
                basePrice = 100;
                ipl       = 5;
                var       = 5;
                ie        = RadicalEvent.CROPFAIL;
                cr        = Resource.RICHSOIL;
                er        = Resource.POORSOIL;
                mtl       = 90;
                mth       = 160;
                break;
            case "ore":
                type      = "natural";
                mtlp      = 2;
                mtlu      = 2;
                ttp       = 3;
                basePrice = 350;
                ipl       = 20;
                var       = 10;
                ie        = RadicalEvent.WAR;
                cr        = Resource.MINERALRICH;
                er        = Resource.POORSOIL;
                mtl       = 30;
                mth       = 50;
                break;
            case "games":
                type      = "industrial";
                mtlp      = 3;
                mtlu      = 1;
                ttp       = 6;
                basePrice = 250;
                ipl       = -10;
                var       = 5;
                ie        = RadicalEvent.BOREDOM;
                cr        = Resource.ARTISTIC;
                er        = null;
                mtl       = 160;
                mth       = 270;
                break;
            case "firearms":
                type      = "industrial";
                mtlp      = 3;
                mtlu      = 1;
                ttp       = 5;
                basePrice = 1250;
                ipl       = -70;
                var       = 100;
                ie        = RadicalEvent.WAR;
                cr        = Resource.WARLIKE;
                er        = null;
                mtl       = 600;
                mth       = 1100;
                break;
            case "medicine":
                type      = "industrial";
                mtlp      = 4;
                mtlu      = 1;
                ttp       = 6;
                basePrice = 650;
                ipl       = -20;
                var       = 10;
                ie        = RadicalEvent.PLAGUE;
                cr        = Resource.LOTSOFHERBS;
                er        = null;
                mtl       = 400;
                mth       = 700;
                break;
            case "machines":
                type      = "industrial";
                mtlp      = 4;
                mtlu      = 3;
                ttp       = 5;
                basePrice = 900;
                ipl       = -30;
                var       = 5;
                ie        = RadicalEvent.LACKOFWORKERS;
                cr        = null;
                er        = null;
                mtl       = 600;
                mth       = 800;
                break;
            case "narcotics":
                type      = "industrial";
                mtlp      = 5;
                mtlu      = 0;
                ttp       = 5;
                basePrice = 3500;
                ipl       = -125;
                var       = 150;
                ie        = RadicalEvent.BOREDOM;
                cr        = Resource.WEIRDMUSHROOMS;
                er        = null;
                mtl       = 2000;
                mth       = 3000;
                break;
            case "robots":
                type      = "industrial";
                mtlp      = 6;
                mtlu      = 4;
                ttp       = 7;
                basePrice = 5000;
                ipl       = -150;
                var       = 100;
                ie        = RadicalEvent.LACKOFWORKERS;
                cr        = null;
                er        = null;
                mtl       = 3500;
                mth       = 5000;
                break;
        }
    }

    /**
     * This method returns the name of the TradeGood.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the ordinal of the minimum tech level to
     * produce the TradeGood.
     *
     * @return the minimum tech level ordinal.
     */
    public int getMtlp() {
        return mtlp;
    }

    /**
     * This method returns the price increase per tech level.
     *
     * @return the price increase.
     */
    public int getIpl() {
        return ipl;
    }

    /**
     * This method returns the maximum percentage the price can vary
     * above or below the base price.
     *
     * @return the variance.
     */
    public int getVar() {
        return var;
    }

    /**
     * This method returns the base price of the TradeGood.
     *
     * @return the base price.
     */
    public int getBasePrice() { return basePrice; }

    /**
     * This method returns the event that caused the radical
     * price increase.
     *
     * @return the radical event.
     */
    public RadicalEvent getIe() {
        return ie;
    }

    /**
     * This method returns the resource that has an unusually
     * low price.
     *
     * @return the resource.
     */
    public Resource getCr() {
        return cr;
    }

    /**
     * This method returns the resource that has an unusually
     * high price.
     *
     * @return the resource.
     */
    public Resource getEr() {
        return er;
    }

    /**
     * This method returns an array list of the possible goods produced
     * at the passed in tech level.
     *
     * @param m the tech level
     * @return an array list of TradeGoods
     */

    public static Iterable<TradeGood> getMTLPs(int m) {
        Collection<TradeGood> tarr = new ArrayList<>();
        if (m >= 0) {
            tarr.add(new TradeGood("water"));
            tarr.add(new TradeGood("furs"));
        } if (m >= 1) {
            tarr.add(new TradeGood("food"));
        } if (m >= 2) {
            tarr.add(new TradeGood("ore"));
        } if (m >= 3) {
            tarr.add(new TradeGood("games"));
            tarr.add(new TradeGood("firearms"));
        } if (m >=4) {
            tarr.add(new TradeGood("medicines"));
            tarr.add(new TradeGood("machines"));
        } if (m >= 5) {
            tarr.add(new TradeGood("narcotics"));
        } if (m >= 6) {
            tarr.add(new TradeGood("robots"));
        }
        return tarr;
    }

    /**
     * This method returns the String name of the TradeGood.
     *
     * @return the name.
     */
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TradeGood) {
            TradeGood good = (TradeGood)obj;
            return name.equals(good.name);
        }

        return false;
    }


}
