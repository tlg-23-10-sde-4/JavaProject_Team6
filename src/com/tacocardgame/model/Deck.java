package com.tacocardgame.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Deck {
    private List<Card> allCards = new ArrayList<>();
    private List<Card> middleStack = new ArrayList<>();  // middle pile list

    /*
     * Adding NewDeck() method to initialize and shuffle
     * ONLY until the below method Deck() is finished
     */
    public NewDeck() {
        allCards.add(new Card("Taco"));    //ctor edits needed if used
        allCards.add(new Card("Cat"));
        allCards.add(new Card("Goat"));
        allCards.add(new Card("Cheese"));
        allCards.add(new Card("Pizza"));
    }


    // if 4, create 48 cards
    // if 5, create 55 cards
    // create 55 - (55 % playerCount) cards
    // e.g., 55 % 4 = 7, so (55-7) cards; 55 % 3 = 1, so (55-1) cards; 55 % 5 = 0, so (55-0) cards
    public Deck(int playerCount) throws IOException {   // TODO: fix up the exception handling
        try {
            Map<String, String> nameImageMap = new HashMap<>(); // aren't all the .put() functions just overwriting each other?
            nameImageMap.put("taco", Files.readString(Path.of("images/taco.txt")));
            nameImageMap.put("cat", Files.readString(Path.of("images/cat.txt")));
            nameImageMap.put("goat", Files.readString(Path.of("images/goat.txt")));
            nameImageMap.put("cheese", Files.readString(Path.of("images/cheese.txt")));
            nameImageMap.put("pizza", Files.readString(Path.of("images/pizza.txt")));
            // or use Map.of()
            // and likewise for "goat", Files.readString(...goat...);

            for (var entry : nameImageMap.entrySet()) {
                // do this 5 times,put this line below in a for loop 1-5
                allCards.add(new Card(entry.getKey(), entry.getValue()));
            }
            Collections.shuffle(allCards);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(allCards);
    }

    public Card nextCard() {
        Card card = allCards.remove(0);
        middleStack.add(card);  // adds the drawn card to the middle stack
        return card;
    }

    public List<Card> getMiddleStack() {
        return middleStack;
    }

    public void clearPile() {
        middleStack.clear();
    }

}
