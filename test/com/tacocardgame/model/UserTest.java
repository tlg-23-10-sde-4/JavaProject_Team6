package com.tacocardgame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.tacocardgame.model.CardType.*;

public class UserTest {

    Pile pile = new Pile();
    Card taco = new Card(TACO);
    Card cat = new Card(CAT);
    Card goat = new Card(GOAT);
    Card cheese = new Card(CHEESE);
    Card pizza = new Card(PIZZA);
    private ArrayList<Card> playerHand;
    Player User;

    @Before
    public void initialize() {
        playerHand = new ArrayList<>(Arrays.asList(goat, cheese, pizza, taco, cat, goat));
        User = new User("User", 3, playerHand);
    }


    @Test
    public void playerSays_shouldOutputCorrectResult() {
        System.out.println("Should print, in order: \nTACO CAT GOAT CHEESE PIZZA Something is wrong...");
        for (int i = 0; i < 6; i++)
            System.out.print(User.playerSays(i) + " ");
    }

    @Test
    public void setName_shouldReturnCorrectUserName() {
        User.setName("That's me!");
        System.out.println(User.getName());
    }

    @Test
    public void getPlayerHand_shouldReturnTheUserHand() { // Also tests setPlayerHand()
        for (Card card : playerHand) {
            System.out.println(card.getType());
        }
    }

    @Test
    public void playerFlipsCard_shouldReturnTheCardAtPosition0AndDecrementTheHand() {
        System.out.print("User hand BEFORE the flip: ");
        for (Card card : playerHand) {
            System.out.print(card.getType() + " ");
        }
        System.out.println("\n");
        System.out.print("Flipped card: ");
        Card card = User.playerFlipsCard();
        System.out.print(card.getType() + "\n");

        System.out.print("User hand AFTER the flip: ");
        for (Card card1 : playerHand) {
            System.out.print(card1.getType() + " ");
        }
    }
    // There might be a problem here
    // Seems like Npc2 is waiting for Npc1 to finish slapping who is waiting for Npc to finish slapping.
    // Need them to run concurrently so Npc4 isn't slapping 6 seconds after we enter slap environment
    @Test
    public void playerSlaps_shouldReturnDTG_whenUserPressesSpaceBar() throws InterruptedException { // There might be a problem here
        long time = User.playerSlaps();
        System.out.println(time);
    }

    @Test
    public void addCardsToPlayerHand_shouldAddTheSelectedCardsToBottomOfPlayerHand() {
        ArrayList<Card> pile = new ArrayList<>(Arrays.asList(pizza, cheese, goat, cat, taco));
        System.out.print("Player hand BEFORE adding cards: ");
        for (Card card : playerHand) {
            System.out.print(card.getType() + " ");
        }
        System.out.println("\n");
        User.addCardsToPlayerHand(pile);
        System.out.print("Player hand AFTER adding cards: ");
        for (Card card1 : playerHand) {
            System.out.print(card1.getType() + " ");
        }
    }
}