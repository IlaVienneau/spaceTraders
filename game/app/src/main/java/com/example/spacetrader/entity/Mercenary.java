package com.example.spacetrader.entity;

import java.util.Random;

public class Mercenary {

    private String name;

    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;

    private int price;
    private boolean hired;

    private Planet homePlanet;

    public Mercenary (String name,
                      Planet homePlanet) {
        this.name = name;
        this.homePlanet = homePlanet;

        Random rand = new Random();
        int randSkill1 = rand.nextInt(17);
        int randSkill2 = rand.nextInt(17 - randSkill1);
        int randSkill3 = rand.nextInt(17 - randSkill1 - randSkill2);
        int randSkill4 = 16 - randSkill1 - randSkill2 - randSkill3;

        int skillOrder = rand.nextInt(4) + 1;

        switch(skillOrder) {
            case 1:
                this.pilotSkill = randSkill1;
                this.fighterSkill = randSkill2;
                this.traderSkill = randSkill3;
                this.engineerSkill = randSkill4;
                break;
            case 2:
                this.fighterSkill = randSkill1;
                this.traderSkill = randSkill2;
                this.engineerSkill = randSkill3;
                this.pilotSkill = randSkill4;
                break;
            case 3:
                this.traderSkill = randSkill1;
                this.engineerSkill = randSkill2;
                this.pilotSkill = randSkill3;
                this.fighterSkill = randSkill4;
                break;
            case 4:
                this.engineerSkill = randSkill1;
                this.pilotSkill = randSkill2;
                this.fighterSkill = randSkill3;
                this.traderSkill = randSkill4;
        }
    }

    public String getMercName(){ return this.name; }

    public int getMercPilotSkill() { return this.pilotSkill; }
    public int getMercFighterSkill() { return this.fighterSkill; }
    public int getMercTraderSkill() { return this.traderSkill; }
    public int getMercEngineerSkill() { return  this.engineerSkill; }

    public int getPrice() { return this.price; }
    public boolean getHired() { return this.hired; }

    public Planet getHomePlanet() { return this.homePlanet; }


    public void setHired(Boolean isHired) { this.hired = isHired; }




}
