package com.tacocardgame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static com.tacocardgame.model.CardType.*;
import static java.lang.Thread.sleep;

public class NpcTest {

    Pile pile = new Pile();
    Card taco = new Card(TACO);
    Card cat = new Card(CAT);
    Card goat = new Card(GOAT);
    Card cheese = new Card(CHEESE);
    Card pizza = new Card(PIZZA);
    private ArrayList<Card> playerHand;
    Player Npc;

    @Before
    public void initialize() {
        playerHand = new ArrayList<>(Arrays.asList(taco, cat, goat, cheese, pizza, taco));
        Npc = new Npc("Npc", 3, playerHand);
    }


    @Test
    public void playerSays_shouldOutputCorrectResult() {
        System.out.println("Should print, in order: \nTACO CAT GOAT CHEESE PIZZA Something is wrong...");
        for (int i = 0; i < 6; i++)
            System.out.print(Npc.playerSays(i) + " ");
    }

    @Test
    public void setName_shouldReturnCorrectNpcName() {
        Npc.setName("Player 2");
        System.out.println(Npc.getName());
    }

    @Test
    public void getPlayerHand_shouldReturnTheNpcHand() { // Also tests setPlayerHand()
        for (Card card : playerHand) {
            System.out.println(card.getType());
        }
    }

    @Test
    public void playerFlipsCard_shouldReturnTheCardAtPosition0AndDecrementTheHand() {
        System.out.print("Npc hand BEFORE the flip: ");
        for (Card card : playerHand) {
            System.out.print(card.getType() + " ");
        }
        System.out.println("\n");
        System.out.print("Flipped card: ");
        Card card = Npc.playerFlipsCard();
        System.out.print(card.getType() + "\n");

        System.out.print("Npc hand AFTER the flip: ");
        for (Card card1 : playerHand) {
            System.out.print(card1.getType() + " ");
        }
    }

    @Test
    public void playerSlaps_shouldReturnDTG() throws InterruptedException {

        System.out.println("Current Time: " + Date().getTime() + "Slap Time: " + Npc.playerSlaps());
    }

    @Test
    public void addCardsToPlayerHand_shouldAddTheSelectedCardsToBottomOfPlayerHand() {
        ArrayList<Card> pile = new ArrayList<>(Arrays.asList(pizza, cheese, goat, cat, taco));
        System.out.print("Player hand BEFORE adding cards: ");
        for (Card card : playerHand) {
            System.out.print(card.getType() + " ");
        }
        System.out.println("\n");
        Npc.addCardsToPlayerHand(pile);
        System.out.print("Player hand AFTER adding cards: ");
        for (Card card1 : playerHand) {
            System.out.print(card1.getType() + " ");
        }
    }



}