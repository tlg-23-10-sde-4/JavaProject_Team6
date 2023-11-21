package com.tacocardgame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.lang.Iterable;
import java.util.Iterator;

import static com.tacocardgame.model.CardType.*;
import static com.tacocardgame.model.Pile.*;

public class PlayerTest {

    Pile pile = new Pile();
    Card taco = new Card(TACO);
    Card cat = new Card(CAT);
    Card goat = new Card(GOAT);
    Card cheese = new Card(CHEESE);
    Card pizza = new Card(PIZZA);
    private ArrayList<Card> playerHand;
    Player player;

    @Before
    public void initialize() {
//        pile.clearPile();
        playerHand = new ArrayList<>(Arrays.asList(taco, cat, goat, cheese, pizza, taco));
        player = new Player("player", 3, (playerHand));
        pile.addToPile(cheese);
        pile.addToPile(taco);
        pile.addToPile(taco);
        pile.addToPile(taco);
        pile.addToPile(taco);
    }

    @Test
    public void pile_shouldBeInstantiated() {
        Card card = pile.showTopOfPile();
        System.out.println(card.getType());
    }

    @Test
    public void playerSays_shouldOutputCorrectResult() {
        System.out.println("Should print, in order: \nTACO CAT GOAT CHEESE PIZZA Something is wrong...");
        for (int i = 0; i < 6; i++)
        System.out.print(Player.playerSays(i) + " ");
    }

    @Test
    public void setName_shouldReturnCorrectPlayerName() {
        player.setName("Tom");
        System.out.println(player.getName());
    }

    @Test
    public void getPlayerHand_shouldReturnThePlayerHand() { // Also tests setPlayerHand()
        for (Card card : playerHand) {
            System.out.println(card.getType());
        }
    }

//    @Test
//    public void playerFlipsCard_shouldReturnTheCardAtPosition0AndDecrementTheHand() {
//        System.out.print("Player hand BEFORE the flip: ");
//        for (Card card : playerHand) {
//            System.out.print(card.getType() + " ");
//        }
//        System.out.println("\n");
//        System.out.print("Flipped card: ");
//        Card card = player.playerFlipsCard();
//        System.out.print(card.getType() + "\n");
//
//        System.out.print("Player hand AFTER the flip: ");
//        for (Card card1 : playerHand) {
//            System.out.print(card1.getType() + " ");
//        }
//    }

    @Test
    public void playerSlaps_shouldBeNull() throws InterruptedException {    // Method overridden in both subclasses
        System.out.println(player.playerSlaps());
    }

    @Test
    public void addCardsToPlayerHand_shouldAddTheSelectedCardsToBottomOfPlayerHand() {

        System.out.print("Player hand BEFORE adding cards: ");
        for (Card card : playerHand) {
            System.out.print(card.getType() + " ");
        }
        System.out.println("\n");
        player.addCardsToPlayerHand(pile);
        System.out.print("Player hand AFTER adding cards: ");
        for (Card card1 : playerHand) {
            System.out.print(card1.getType() + " ");
        }
    }


    @Test
    public void addCardsToPlayerHand_shouldNotWork_whenAddingNullCard() {
        pile.clearPile();
        pile.addToPile(null);
        player.addCardsToPlayerHand(pile);

    }



}