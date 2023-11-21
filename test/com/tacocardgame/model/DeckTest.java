//package com.tacocardgame.model;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.sql.Array;
//import java.util.*;
//
//import static com.tacocardgame.model.CardType.*;
//import static org.junit.Assert.*;
//
//public class DeckTest {
//    private List<Card> allCards = new ArrayList<>();
//    Deck deck = new Deck();
//    Pile pile = new Pile();
//    Card taco = new Card(TACO);
//    Card cat = new Card(CAT);
//    Card goat = new Card(GOAT);
//    Card cheese = new Card(CHEESE);
//    Card pizza = new Card(PIZZA);
//    private ArrayList<Card> playerHand;
//    private ArrayList<Player> players = new ArrayList<>();
//    Player player;
//
//    public DeckTest() throws IOException {
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        Deck deck = new Deck();
//        playerHand = new ArrayList<>();
//        players.add(new User("player", 1, new ArrayList<>(playerHand)));
//        players.add(new Npc("Chuck", 2, new ArrayList<>(playerHand))); // NPC players
//        players.add(new Npc("CJ", 3, new ArrayList<>(playerHand)));
//        players.add(new Npc("Justin", 4, new ArrayList<>(playerHand)));
//        players.add(new Npc("Keith", 5, new ArrayList<>(playerHand)));
//    }
//
//    @Test
//    public void deck() throws IOException {
//        Deck deck = new Deck();
//        int i = deck.getAllCards().size();
//        System.out.println("Size is: " + i);
//        for (Card card : deck.getAllCards()) {
//            System.out.println(card.getType());
//            System.out.println("\n");
//        }
//    }
//
//    @Test
//    public void getAllCards_shouldReturnTrue_lengthIs55() {
//        assertTrue(deck.getAllCards().size() == 55);
//    }
//
//    @Test
//    public void nextCard_shouldReturnTrue_whenComparingSizeBeforeCalled() {
//        int sizeBefore = deck.getAllCards().size();
//        int sizeAfter;
//        deck.nextCard();
//        sizeAfter = deck.getAllCards().size();
//        assertTrue(sizeBefore == (sizeAfter + 1));
//    }
//
//    @Test
//    public void distributeCards_shouldReturnTrue_when5Players() throws IOException {
//        deck.distributeCards(players);
//        for (Player player : players) {
//            assertTrue(this.playerHand.size() == 11);
//        }
//    }
//
//
//    @Test
//    public void distributeCards() throws IOException {
//        Deck deck = new Deck();
//        System.out.println("There are " + players.size() + " players");
//        deck.distributeCards(players);
//        for (int i = 0; i < players.size(); i++) {
//            Player currentPlayer = players.get(i);
//            System.out.println(currentPlayer.getPlayerId());
//            for (Card card : currentPlayer.playerHand) {
//                System.out.println(card.getType());
//            }
//        }
//    }
//}