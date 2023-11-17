package com.tacocardgame.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Player {

    // FIELDS
    static final List<String> tacoList = new ArrayList<>(
            List.of("TACO", "CAT", "GOAT", "CHEESE", "PIZZA"));
    static int tacoListCounter = 0;    // TODO: make sure this resets to 0 when a player loses a round
    private List<Card> playerHand = new ArrayList<>();  // TODO: implement methods to add the pile (switch to Deque?)
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

    public static String playerSays() { // TODO: get rid of magic numbers
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

    public Card playerFlipsCard() {
        Card flipCard = this.playerHand.get(0);
        this.playerHand.remove(0);
        return flipCard;
    }

    public void playerChecks() {
        // if the spoken word and matches the flipped card
        // the player can playerSlaps()
        if (Player.playerSays())
    }

    public void playerWaits() {

    }

    public Date playerSlaps() {
        Date timeOfSlap = null;
        // make it return the local time that the player slaps by default
        // then override that in User returning the local time that the user does some action
        return timeOfSlap;
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