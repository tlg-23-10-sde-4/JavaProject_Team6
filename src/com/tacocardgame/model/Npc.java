package com.tacocardgame.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Npc extends Player {

    private String name;

    public Npc(String name, int playerID) {
        getName();
        getPlayerId();
    }

    public Npc(String name, int playerID, List<Card> playerHand) {
        getName();
        getPlayerId();
        playerHand = getPlayerHand();
    }

    @Override
    public Date playerSlaps() throws InterruptedException {

        double doubleWaitTime = 1000 + (1000 * Math.random());   // Gives a double value between 1000 and 2000, roughly
        //TODO: I'm sure there's a better way to pass a random long to this.wait()
        long waitTime = Math.round(doubleWaitTime); // converts the double to long

        this.wait(waitTime);    // this. to make sure each Npc Player has their own wait time

        // the time - down to milliseconds - of the Npc Player slap
        // SHOULD!!! happen after the wait as the code is read sequentially
        Date result = new Date();

        // For use in an ArrayList<> or similar so we can determine the loser
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}