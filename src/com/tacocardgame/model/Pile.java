package com.tacocardgame.model;

import java.util.*;

class Pile {

    // investigate Stack class (java.util)
    private Deque<Card> pile = new ArrayDeque<>() {

    };


    public void addToPile(Card card) {
        pile.push(card); // goes "on top" which means position 0
    }

    public Card showTopOfPile() {
        return pile.peekFirst();   // shows the top of the pile
    }

    public void clearPile() {
        pile.clear();
    }
}