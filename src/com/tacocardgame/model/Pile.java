package com.tacocardgame.model;

import com.tacocardgame.model.Card;

import java.util.Stack;

class Pile {
    // investigate Stack class (java.util)
    private Stack<Card> cards = new Stack<>();


    public void add(Card card) {
        cards.add(card); // goes "on top" which I means position 0
    }
}