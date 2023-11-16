package com.tacocardgame.model;

public class Npc extends Player {

    private String name;

    @Override
    public static void playerSays() {

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