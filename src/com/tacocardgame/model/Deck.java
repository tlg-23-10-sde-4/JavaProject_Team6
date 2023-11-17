package com.tacocardgame.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Deck {
    private List<Card> allCards = new ArrayList<>();

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

    public Card nextCard() {
        return allCards.remove(0);
    }
}
