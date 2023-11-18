

package com.tacocardgame.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player {

    // FIELDS
    // static final List<String> tacoList = new ArrayList<>(  //consider making enum class
    //        List.of("TACO", "CAT", "GOAT", "CHEESE", "PIZZA"));
    // static int tacoListCounter = 0;    // TODO: (NEED TO DISCUSS) make sure this resets to 0 when a player loses a round
    private List<Card> playerHand = new ArrayList<>();
    private String name;
    private int playerId;
    // CONSTRUCTOR

    public Player() {

    }

    public Player(String name, int playerId) {
        setName(name);
        setPlayerId(playerId);

    }

    private void setPlayerId(int playerId) {
        this.playerId = playerId;
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

    public void playerFlipsCard() {
        // Player takes player.playerHand(0) and turns it over into the pile
    }

    public void playerChecks() {

    }

    public void playerWaits() {

    }

    public Date playerSlaps() {
        Date timeOfSlap = null;
        // make it return the local time that the player slaps by default
        // then override that in User returning the local time that the user does some action
        return timeOfSlap;
    }

    public void addCardsToPlayerHand(List<Card> cards) {
        playerHand.addAll(cards);
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