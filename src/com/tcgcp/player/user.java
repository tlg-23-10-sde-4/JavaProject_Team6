package com.tcgcp.player;

public class user extends player {

    private String name;

    public user(String name) {
        this.name = name;
    }

    @Override
    public static void playerSays() {

    }

    @Override
    public static void displayCard() {

    }

    @Override
    public static void playerChecks() {

    }

    @Override
    public static void playerWaits() {

    }

    @Override
    public static void playerSlaps() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}