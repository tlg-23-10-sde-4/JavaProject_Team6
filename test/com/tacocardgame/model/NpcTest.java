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
        playerHand = new ArrayList<>(Arrays.asList(cat, goat, cheese, pizza, taco, cat));
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
    // There might be a problem here
    // Seems like Npc2 is waiting for Npc1 to finish slapping who is waiting for Npc to finish slapping.
    // Need them to run concurrently so Npc4 isn't slapping 6 seconds after we enter slap environment
    @Test
    public void playerSlaps_shouldReturnDTG() throws InterruptedException { // There might be a problem here
        Npc Npc1 = new Npc("Npc", 3, playerHand);
        Npc Npc2 = new Npc("Npc", 3, playerHand);
        Npc Npc3 = new Npc("Npc", 3, playerHand);
        Npc Npc4 = new Npc("Npc", 3, playerHand);
        Npc Npc5 = new Npc("Npc", 3, playerHand);
        Npc Npc6 = new Npc("Npc", 3, playerHand);
        System.out.println("Current Time: " + new Date().getTime() + "Slap Time: " + Npc.playerSlaps());
        long time = new Date().getTime();
        long time1 = Npc.playerSlaps();
        long time2 = Npc1.playerSlaps();
        long time3 = Npc2.playerSlaps();
        long time4 = Npc3.playerSlaps();
        long time5 = Npc4.playerSlaps();
        long time6 = Npc5.playerSlaps();
        long time7 = Npc6.playerSlaps();
        System.out.println(time - time1);
        System.out.println(time - time2);
        System.out.println(time - time3);
        System.out.println(time - time4);
        System.out.println(time - time5);
        System.out.println(time - time6);
        System.out.println(time - time7);
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