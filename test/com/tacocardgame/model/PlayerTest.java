package com.tacocardgame.model;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.tacocardgame.model.CardType.*;
import static org.junit.Assert.*;

public class PlayerTest {

    @Before
    public void initialize() throws IOException {
        Deck deck = new Deck();
        Pile pile = new Pile();
        Card taco = new Card(TACO);
        Card cat = new Card(CAT);
        Card goat = new Card(GOAT);
        Card cheese = new Card(CHEESE);
        Card pizza = new Card(PIZZA);
        ArrayList<Card> playerHand = new ArrayList<>(Arrays.asList(taco, cat, goat, cheese, pizza, taco));

        User tom = new User("Tom", 3, (playerHand));
    }


    @Test
    public void playerSays_shouldOutputCorrectResult() {
        System.out.println("Should print, in order: \nTACO CAT GOAT CHEESE PIZZA");
        for (int i = 0; i < 5; i++)
        System.out.print(Player.playerSays(i) + " ");
    }

    @Test
    public void getName_shouldReturnNamePlayerName() {
        Player tom = new Player("Tom", 3);
        System.out.println(tom.getName());
    }

    @Test
    public void getPlayerID_shouldReturnPlayerID() {
        Player tom = new Player ("Tom", 3);
        System.out.println(tom.getPlayerId());
    }

    @Test
    public void getPlayerHand_shouldReturnThePlayerHand() {
        Card taco = new Card(TACO);
        Card cat = new Card(CAT);
        Card goat = new Card(GOAT);
        Card cheese = new Card(CHEESE);
        Card pizza = new Card(PIZZA);
        ArrayList<Card> playerHand = new ArrayList<>(Arrays.asList(taco, cat, goat, cheese, pizza, taco));
        Player tom = new Player ("Tom", 3, playerHand);
        for (Card card : playerHand) {
            System.out.println(card.getType());
        }
    }

}