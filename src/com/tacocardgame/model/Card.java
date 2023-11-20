package com.tacocardgame.model;

public class Card {

    private CardType type;
    private String image;

    public Card(CardType type) {
        this.type = type;
    }

    public Card(CardType type, String image) {
        this.type = type;
        this.image = image;
    }

    public void show(String image) {

        System.out.println(image);
    }

    public CardType getType() {
        return type;
    }
}