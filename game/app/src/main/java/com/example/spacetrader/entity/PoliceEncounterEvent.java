package com.example.spacetrader.entity;

import java.util.Random;

public class PoliceEncounterEvent {
    //need constructor with player passed in
    //need methods for each choice
    Player player;
    Random rand;
    PoliceEncounterEvent(Player player) {
        this.player = player;
    }
    public String flee() {
        int chance = rand.nextInt(100);
        int skill = player.getPilotSkill();
        if (skill*5 + chance > 20) {
            return "You successfully fled from the Space Police!";
        } else {
            return "Your flight was unsuccessful and you were caught by the Space Police.";
        }
    }

    public String fight() {
        int chance = rand.nextInt(100);
        int skill = player.getFighterSkill();
        if (skill*5 + chance > 20) {
            return "You successfully fought off the Space Police!";
        } else {
            return "You lost the fight and now have to deal with the Space Police.";
        }
    }

    public String surrender() {

    }
}
