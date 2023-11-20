package com.tacocardgame.model;

import java.util.*;

public class Pile {


    private Deque<Card> pile = new ArrayDeque<>();

    public void addToPile(Card card) {
        pile.push(card);
    }

    public Card showTopOfPile() {
        return pile.peekFirst();
    }



    public int getSize() {
        return pile.size();
    }

    public void clearPile() {
        pile.clear();
    }

//    @Override
//    private String toString() {
//        return
//    }
}