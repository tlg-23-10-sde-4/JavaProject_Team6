package com.tacocardgame.model;

import com.apps.util.Prompter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class User extends Player {

    public User(String name) {
        super(name);
    }

    public User(String name, int playerId) {
        super(name, playerId);
    }

    public User(String name, int playerId, ArrayList<Card> playerHand) {
        super(name, playerId, playerHand);

    }

    // CANNOT test in IntelliJ; instead you must copy the method in Jshell and run it from there
    // The method ALMOST works correctly
    // /Currently need to press spacebar AND THEN enter
    /// If you press any other combination you will get the default value

    @Override
    public long playerSlaps() {
        // User input logic for slapping
        long startTime = System.currentTimeMillis();
        Prompter prompter = new Prompter(new Scanner(System.in));
        prompter.prompt("Press the space bar to slap: ");

        long endTime = System.currentTimeMillis();
        return endTime - startTime; // Return slap time
    }
}