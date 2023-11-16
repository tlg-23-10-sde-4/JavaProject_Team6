package com.tacocardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    // FIELDS
    private List<String> tacoList = new ArrayList<>(
            List.of("TACO", "CAT", "GOAT", "CHEESE", "PIZZA"));
    int tacoListCounter = 0;
    private List<Card> playerHand = new ArrayList<>();
    private String name;

    // METHODS

    public String playerSays() {
        // Player says next of "Taco, Cat, Goat, Cheese, Pizza"
        String result;
        if (tacoListCounter <= 3) {
            result = tacoList.get(tacoListCounter);
            tacoListCounter++;
        }
        else {
            result = tacoList.get(4);
            tacoListCounter = 0;
        }
        return result;
    }

    public static void displayCard() {
        // Player takes player.playerHand(0) and turns it over into the pile
    }

    public static void playerChecks() {

    }

    public static void playerWaits() {

    }

    public void playerSlaps() {

    }

    // GETTERS & SETTERS

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