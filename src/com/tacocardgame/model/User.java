package com.tacocardgame.model;

import com.apps.util.Prompter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class User extends Player {

    public User(String name, int playerId) {
        setName(name);
        setPlayerId(playerId);
    }

    public User(String name, int playerId, ArrayList<Card> playerHand) {
        setName(name);
        setPlayerId(playerId);
        setPlayerHand(playerHand);
    }

    // CANNOT test in IntelliJ; instead you must copy the method in Jshell and run it from there
    // The method ALMOST works correctly
    // /Currently need to press spacebar AND THEN enter
    /// If you press any other combination you will get the default value

    @Override
    public long playerSlaps() {
        long result = 1234567890;   // CJ: for testing - see if we are properly overriding the super
        System.out.println("Scanner should load next"); // CJ: for testing

        Scanner playerSlap = new Scanner(System.in);
        String userInput = playerSlap.nextLine();
        if (userInput.equalsIgnoreCase(" ")) {
            result = new Date().getTime();
        }
        return result;
    }

    public static String userSlaps() {
        long startTime = System.currentTimeMillis();

        Prompter prompter = new Prompter(new Scanner(System.in));
        prompter.prompt("Press the space bar to slap: ");
        String userInput = prompter.prompt("");

        long endTime = System.currentTimeMillis(); //record the endtime
        long slapTime = endTime - startTime;

        if (userInput.equals(" ")) {
            System.out.println(Player.getName() + " slaps");
            return getName() + " slap time: " + startTime +"ms";
        } else {
            return getName() + "didnt slap";
        }
    }

}