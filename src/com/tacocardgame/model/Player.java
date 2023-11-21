package com.tacocardgame.model;

import java.util.*;

public abstract class Player {  //abstract class complete #JS

    // TODO: (NEED TO DISCUSS) make sure this resets to 0 when a player loses a round
    private List<Card> playerHand = new ArrayList<>();
    private String name;
    private int playerId;

    // CONSTRUCTOR

    public Player() {

    }

    public Player(String name, int playerId) {
        this.name = name;
        this.playerId = playerId;
    }

    public Player(String name, int playerId, ArrayList<Card> playerHand) {
        this.name = name;
        this.playerId = playerId;
        this.playerHand = playerHand;
    }

    // METHODS

    public String getName() {
        return name;
    }

    public void addCardsToPlayerHand(List<Card> cards) {
        this.playerHand.addAll(cards);
    }

    public void takeTurn(Pile pile) {
        Card cardFlipped = playerFlipsCard(pile);
        CardType cardType = cardFlipped.getType();
        String asciiArt = Deck.getAsciiCardType(cardType);
        String sayWord = (String) playerSays(cardType.getPosition());

        System.out.println(getName() + " flipped " + cardFlipped + " and says " + sayWord);
        System.out.println(asciiArt);
    }

    public Card playerFlipsCard(Pile pile) {
        if (playerHand.isEmpty()) {
            throw new NoSuchElementException("No cards are left to flip");
        }
        Card card = playerHand.remove(0); // removes the first card from playerHand
        pile.addToPile(card);  // adds this instance of card to the pile.  This is why instances are super important.
        return card;
    }

    public Object playerSays(int position) { // CJ: test successful 11/19
        CardType findPosition = CardType.findByPosition(position);
        return findPosition != null ? findPosition.getLabel() : "Something is wrong, CJ help!";

    }

    // implement the full version in class Npc and class User.
    public abstract long playerSlaps();
}