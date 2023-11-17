package com.tacocardgame.model;

import com.tacocardgame.model.Card;

import java.util.Stack;

class Pile {
    // investigate Stack class (java.util)
    private Stack<Card> cards = new Stack<>();  //The Stack class represents a last-in-first-out (LIFO) stack of objects.


    public void add(Card card) {
        cards.add(card); // goes "on top" which means position 0
    }
}