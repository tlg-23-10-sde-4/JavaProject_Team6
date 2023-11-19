package com.tacocardgame.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.*;
import java.util.NoSuchElementException;

public class Deck {
    private List<Card> allCards = new ArrayList<>();

    public Deck() throws IOException {


        try {  // CJ to answer your question about over-right.  Great question.  Since it's a map there's a key,value pair.
            // it would only over-write if the keys were the same.

            //We create the initial array by assigning it to a Map.

            Map<String, String> nameTacoMap = new HashMap<>();
            nameImageMap.put("taco", Files.readString(Path.of("resources/images/taco.txt")));
            nameImageMap.put("cat", Files.readString(Path.of("resources/images/cat.txt")));
            nameImageMap.put("goat", Files.readString(Path.of("resources/images/goat.txt")));
            nameImageMap.put("cheese", Files.readString(Path.of("resources/images/cheese.txt")));
            nameImageMap.put("pizza", Files.readString(Path.of("resources/images/pizza.txt")));



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

