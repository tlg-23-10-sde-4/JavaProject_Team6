package com.tacocardgame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;

import static com.tacocardgame.model.CardType.*;
import static org.junit.Assert.*;

public class PileTest {

    Pile pile = new Pile();
    Card taco = new Card(TACO);
    Card cat = new Card(CAT);
    Card goat = new Card(GOAT);
    Card cheese = new Card(CHEESE);
    Card pizza = new Card(PIZZA);
    Card card;
    private ArrayList<Card> playerHand;
    Player player;

    @Before
    public void initialize() {
        pile.addToPile(cat);
        pile.addToPile(taco);
        pile.addToPile(cheese);

    }


    @Test
    public void addToPile_shouldReturnTrue_whenAddCat() {
        pile.addToPile(cat);
        System.out.println(pile.showTopOfPile());
    }



    @Test
    public void addToPile_shouldReturnException_whenAddNull() {
        Card card = null;
        pile.addToPile(card);
        System.out.println(pile.showTopOfPile());
    }

    @Test
    public void showTopOfPile_shouldReturnLastCardFromBefore() {
        card = pile.showTopOfPile();
        System.out.println(card.getType());
    }

    @Test
    public void getSize_shouldReturn3() {
        System.out.println(pile.getSize());
    }

    @Test
    public void clearPile_shouldReturnZero_afterClearPile() {
        pile.clearPile();
        System.out.println(pile.getSize());
    }


}