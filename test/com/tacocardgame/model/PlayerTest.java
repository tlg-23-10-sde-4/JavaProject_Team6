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

    Pile pile = new Pile();
    Card taco = new Card(TACO);
    Card cat = new Card(CAT);
    Card goat = new Card(GOAT);
    Card cheese = new Card(CHEESE);
    Card pizza = new Card(PIZZA);
    private ArrayList<Card> playerHand;
    Player tom;

    @Before
    public void initialize() {
        playerHand = new ArrayList<>(Arrays.asList(taco, cat, goat, cheese, pizza, taco));
        tom = new Player("Tom", 3, (playerHand));
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
    public void getPlayerHand_shouldReturnThePlayerHand() { // Also tests setPlayerHand()
        for (Card card : playerHand) {
            System.out.println(card.getType());
        }
    }

    @Test
    public void playerFlipsCard_shouldReturnTheCardAtPosition0AndDecrementTheHand() {
        System.out.print("Player hand BEFORE the flip: ");
        for (Card card : playerHand) {
            System.out.print(card.getType() + " ");
        }
        System.out.println("\n");
        System.out.print("Flipped card: ");
        Card card = tom.playerFlipsCard();
        System.out.print(card.getType() + "\n");

        System.out.print("Player hand AFTER the flip: ");
        for (Card card1 : playerHand) {
            System.out.print(card1.getType() + " ");
        }
    }



}