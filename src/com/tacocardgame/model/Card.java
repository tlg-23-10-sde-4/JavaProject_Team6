package com.tacocardgame.model;

public class Card {

        private String name;
        private String image;

        public Card(String name, String image) {
            this.name = name;
            this.image = image;
        }

        public void show() {
            System.out.println(image);
        }
}
