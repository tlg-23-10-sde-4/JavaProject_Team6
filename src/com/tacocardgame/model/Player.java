

package com.tacocardgame.model;

import java.util.*;

public class Player {

    // FIELDS
    // static final List<String> tacoList = new ArrayList<>(  //consider making enum class
    //        List.of("TACO", "CAT", "GOAT", "CHEESE", "PIZZA"));
    // static int tacoListCounter = 0;    // TODO: (NEED TO DISCUSS) make sure this resets to 0 when a player loses a round
    private static List<Card> playerHand;
    private String name;
    private int playerId;

    private boolean isUser;

    // CONSTRUCTOR

    // probably only need one constructor
    public Player() {

    }

    public Player(String name, int playerId) {
        setName(name);
        setPlayerId(playerId);
    }

    public Player(String name, int playerId, ArrayList<Card> playerHand) {
        setName(name);
        setPlayerId(playerId);
        setPlayerHand(playerHand);
    }

    // METHODS

    // CJ: test successful 11/19  # JS- I changed playerFlipsCard to dec&inc card
    //# JS- need to retest.  This will return an instance of Card - as a counted pile From Pile
    // so I'm saying playerFlipsCard from the Pile pile and will return the instance of Card card-,
    // so we can use it for playerSlaps().
    public static Card playerFlipsCard(Pile pile) {
        if (playerHand.isEmpty()) {
            throw new NoSuchElementException("No cards are left to flip");
        }

        Card card = playerHand.remove(0); // removes the first card from playerHand

        if (card == null) {
            throw new NullPointerException("The card you tried to flip is null");
        }

        pile.addToPile(card);  // adds this instance of card to the pile.  This is why instances are super important.
        return card;  // now we can use Player.card as our clearing pile everytime we have a slap.

    }

    public static String playerSays(int position) { // CJ: test successful 11/19
        CardType cardType = CardType.findByPosition(position);
        if (cardType != null) {
            return cardType.getLabel();
        } else {
            return "Something is wrong with Player.playerSays";
        }
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

    public long playerSlaps() {
        long timeOfSlap = 987654321;    // CJ: for testing - see if it's properly overwritten
        return timeOfSlap;
    }

    public void addCardsToPlayerHand(Pile pile) {
        ArrayList<Card> pileAsArrayList;
        pileAsArrayList = pile.dequeToArrayList();
        playerHand.addAll(pileAsArrayList);
    }

    // GETTERS & SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public static String getName() {
        return this.name;
    }

    public static List<Card> getPlayerHand() {
        return playerHand;
    }

    public static void setPlayerHand(ArrayList<Card> playerHand) {
        Player.playerHand = playerHand;
    }

    public int getPlayerId() {
        return playerId;
    }

    void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

//    public boolean isUser() {
//        return isUser;
//    }
//
//    public void setUser(boolean isUser) {
//        this.isUser = isUser;
//    }


    public void takeTurn(Pile pile) {
        Card cardFlipped = playerFlipsCard(pile);
        CardType cardType = cardFlipped.getType();
        String asciiArt = Deck.getAsciiCardType(cardType);
        String sayWord = playerSays(cardType.getPosition());

        System.out.println(getName() + " flipped " + cardFlipped + " and says " + sayWord);
        System.out.println(asciiArt);
    }
}