package com.tacocardgame.model;

import java.util.List;

public class Npc extends Player {

    private String name;


    public Npc(String name, List playerHand) {
        getName();
        playerHand = getPlayerHand();
    }

    @Override
    public void playerChecks() {

    }

//    @Override
    public static void playerWaits() {

    }

//    @Override
    public static void playerSlaps() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}