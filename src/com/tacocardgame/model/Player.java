package com.tacocardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    // FIELDS
    static List<String> tacoList = new ArrayList<>(
            List.of("TACO", "CAT", "GOAT", "CHEESE", "PIZZA"));
    static int tacoListCounter = 0;    // TODO: make sure this resets to 0 when a player loses a round
    private List<Card> playerHand = new ArrayList<>();
    private String name;

    // CONSTRUCTOR

    public Player() {

    }

    public Player(String name) {

    }

    public Player(String name, List<Card> playerHand) {
        setName(name);
        setPlayerHand(playerHand);
    }

    // METHODS

    public static String playerSays() {
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

    public  void playerChecks() {

    }

    public static void playerWaits() {

    }

    public static void playerSlaps() {

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