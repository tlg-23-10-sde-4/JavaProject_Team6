

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

    // probably only need one constructor
    public Player() {

    }

    // TODO: does the player have a <playerHand> filled with cards? If yes, then we need a constructor for it
    public Player(String name, int playerId) {
        setName(name);
        setPlayerId(playerId);
    }

    // METHODS

    public Card playerFlipsCard() {
        Card result;

        result = playerHand.get(0);
        playerHand.remove(0);

        return result;
    }

    public void playerChecks() {    // What is the player checking here?
        // If we're checking for a match between playerFlipsCard and playerSays
        // I think that's better compared in GameController or Round
        // e.g.
//              int i = 0;
//                do {
//                    currentCard = valueOf(players(i).playerFlipsCard());
//                    currentSays = players(i).playerSays();
//                    if (currentCard.equals(currentSays)) {
//                        //for (Player player : players)
//                            playerSlaps();
//                        ?break?
//                    }
//                    else {
//                        i++;
//                    }     // returns to the top of the "do" statement but with i incremented
//                    if (i == 5) {   // <players> has 0-4; if i == 5 then reset to 0, thus completing the circle
//                        i = 0;
//                    }
//                }
//                while (player.getPlayerHand().isEmpty()) == false);
    }

    public Date playerSlaps() throws InterruptedException {
        Date timeOfSlap = null;
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

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public static String getPlayerSays(int position) {
        CardType cardType = CardType.findByPosition(position);
        if (cardType != null) {
            return cardType.getLabel();
        }
        else {
            return "Something is wrong with Player.getPlayerSays";
        }
    }

}