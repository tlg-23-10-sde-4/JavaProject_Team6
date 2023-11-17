package com.tacocardgame.model;

import com.tacocardgame.model.Card;

import java.util.Stack;

class Pile {

    // investigate Stack class (java.util)
    private Stack<Card> cards = new Stack<>();


    public void addToPile(Card card) {
        cards.add(card); // goes "on top" which means position 0
    }

    public Card showTopOfPile() {
        return cards.get(0);
    }

    public void clearPile() {
        cards.clear();
    }
}