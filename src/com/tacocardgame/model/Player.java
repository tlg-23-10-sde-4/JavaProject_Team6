package com.tacocardgame.model;

import com.tacocardgame.controller.GameController;

import java.util.ArrayList;
import java.util.List;


public class Player {


    private List<Card> playerHand = new ArrayList<>();  //  List of cards each player maintains
    // cards are distro'd from Deck to User's hand and NPC hand after Deck collection.shuffle #js
    private String name;
    //possibly add playerCount field ?? #js

    //ctors
    public Player(String name) {  // constructor for Player class
        this.name = name;
    }

    public Player(List<Card> playerHand, String name) { // constructor for Player class
        this.playerHand = playerHand;
        this.name = name;
    }

    public Player() {
        this.playerHand = new ArrayList<>();

    }


    public static void playerSays() {  // we could do a smart enum class here since they never change.
        // Player says next of "Taco, Cat, Goat, Cheese, Pizza"

    }

    public static void displayCard() {  // should change to playerDisplaysCard()
        // gets player's hand from playerHand and System.out.println(playerHand.get(0).toString()); #js
        //   player.playerHand() should decrement player hand and increment pile #js
    }

    public static void playerChecks() {  // should change to playerCompare (this checks if playerSays() matches
        // playerDisplaysCard()

    }

    public static void playerWaits() {  // I don't think this is needed anymore unless we can use it to slow
        // the flow of the game so there's a definitive pause between display card of previous player #js

    }

    public void playerSlaps() {  //prompts player to slap a card
        System.out.println(this.getName(GameController.) + " slaps a card");

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


    public boolean hasNoCards() {
        return playerHand.size() == 0;
    }
}