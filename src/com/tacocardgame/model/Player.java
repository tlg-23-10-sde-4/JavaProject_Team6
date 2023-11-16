package com.tacocardgame.model;

import java.util.ArrayList;

public class Player {



    private List<Card> playerHand = new ArrayList<>();
    private String name;

    public static void playerSays() {
        // Player says next of "Taco, Cat, Goat, Cheese, Pizza"

    }

    public static void displayCard() {
        // Player takes player.playerHand(0) and turns it over into the pile
    }

    public static void playerChecks() {

    }

    public static void playerWaits() {

    }

    public static void playerSlaps() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(List<Card> playerHand) {
        this.playerHand = playerHand;
    }


}