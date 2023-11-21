package com.tacocardgame.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.NoSuchElementException;

public class Deck {
    private List<Card> allCards = new ArrayList<>();
    Map<CardType, String> nameTacoMap = new HashMap<>();   //moved this outside of the try for ascii

    public Deck() throws IOException {
        allCards = new ArrayList<>();
		
        try {
            nameTacoMap.put(CardType.TACO, Files.readString(Path.of("resources/images/taco.txt")));
            nameTacoMap.put(CardType.CAT, Files.readString(Path.of("resources/images/cat.txt")));
            nameTacoMap.put(CardType.GOAT, Files.readString(Path.of("resources/images/goat.txt")));
            nameTacoMap.put(CardType.CHEESE, Files.readString(Path.of("resources/images/cheese.txt")));
            nameTacoMap.put(CardType.PIZZA, Files.readString(Path.of("resources/images/pizza.txt")));


            for (var entry : nameTacoMap.entrySet()) {
                for (int i = 0; i < 11; i++) { // Create 11 cards of each type
                    allCards.add(new Card(entry.getKey(), entry.getValue()));
                }
            }
            Collections.shuffle(allCards);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Card> getAllCards() {
        return new ArrayList<>(allCards); // Return a copy of the list
    }

    public Card nextCard() {
        //
        if (allCards.isEmpty()) {
            throw new NoSuchElementException("The Deck is empty");
        }

        List<Card> temp = new ArrayList<>();
        temp.add(allCards.get(0));
        allCards.remove(0);

        return temp.get(0);
    }

    public void distributeCards(List<Player> players) throws IOException {
        Deck deck = new Deck();
        int cardsPerPlayer = deck.getAllCards().size() / players.size();
        for (Player player : players) {
            for (int i = 0; i < cardsPerPlayer; i++) {
                player.getPlayerHand().add(deck.nextCard()); // Assuming nextCard() method removes and returns the top card
            }
        }
    }

    public String getAsciiCardType(CardType cardType){      ///get ascii art by card type
        return nameTacoMap.get(cardType);
    }

}

