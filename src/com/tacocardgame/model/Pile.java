package com.tacocardgame.model;

import java.util.*;

class Pile {

    // investigate Stack class (java.util)
    private Deque<Card> pile = new ArrayDeque<>();


    public void addToPile(Card card) {
        pile.push(card);
    }

    public Card showTopOfPile() {
        return pile.peekFirst();
    }

    public void clearPile() {
        pile.clear();
    }
}