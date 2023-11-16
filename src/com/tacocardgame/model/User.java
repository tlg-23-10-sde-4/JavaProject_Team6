package com.tacocardgame.model;

import java.util.List;

public class User extends Player {

    public User(String name) {
        this.name = name;
    }

    public User(String name, List playerHand) {
        setName(name);
        setPlayerHand(playerHand);
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



}