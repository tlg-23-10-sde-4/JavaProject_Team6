package com.tacocardgame.model;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Npc extends Player {

    private String name;

    public Npc(String name, int playerId) {
        super(name, playerId); // Call the constructor of the superclass
    }

    public Npc(String name, int playerId, ArrayList<Card> playerHand) {
        super(name, playerId, playerHand); // Call the constructor of the superclass
    }

    @Override
    public Long playerSlaps() {
        // Simulate a delay for NPC reaction time
        long delay = (long)(1000 + Math.random() * 1000); // Delay between 1 to 2 seconds
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            // Handle exception
        }
        return System.currentTimeMillis(); // Return the current time after the delay
    }

    public void setName(String name) {
        this.name = name;
    }

}