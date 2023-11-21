package com.tacocardgame.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;

public class Npc extends Player {

    private String name;

    public Npc(String name, int playerID) {
        getName();
        getPlayerId();
    }

    public Npc(String name, int playerID, ArrayList<Card> playerHand) {
        getName();
        getPlayerId();
        setPlayerHand(playerHand);
    }

    @Override
    public long playerSlaps() {

//        double doubleWaitTime = 1000 + (1000 * Math.random());   // Gives a double value between 1000 and 2000, roughly
//        //TODO: I'm sure there's a better way to pass a random long to this.wait()
//        long waitTime = Math.round(doubleWaitTime); // converts the double to long
//
//        sleep(waitTime);
//
//        // the time - down to milliseconds - of the Npc Player slap
//        // SHOULD!!! happen after the wait as the code is read sequentially
        long result = new Date().getTime();

        // For use in an ArrayList<> or similar so we can determine the loser
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

}