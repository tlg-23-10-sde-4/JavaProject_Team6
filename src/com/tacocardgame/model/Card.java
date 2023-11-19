package com.tacocardgame.model;

public class Card {

    private CardType type;
    private String image;

    public Card(CardType type, String image) {
        this.type = type;
        this.image = image;
    }

    public void show() {
        System.out.println(image);
    }

    public CardType getType() {       //get name of card in middlecard obj
        return type;
    }
}