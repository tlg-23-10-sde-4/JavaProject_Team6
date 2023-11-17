package com.tacocardgame.model;

import java.util.List;

public class Npc extends Player {

    private String name;


    public Npc(String name, List playerHand) {
        getName();
        playerHand = getPlayerHand();
    }

    public void playerChecks() {

    }


    public void playerWaits() {

    }


    public void playerSlaps() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}