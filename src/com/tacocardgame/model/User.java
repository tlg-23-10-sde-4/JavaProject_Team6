package com.tacocardgame.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    // intent is to capture the exact time of the user's slap (pressing spacebar) for comparison to the Npc Players
//    @Override
//    public long playerSlaps() {
//        long result = 0;
//        System.out.println("Scanner should load next"); // CJ: for testing
//        Scanner playerSlap = new Scanner(System.in);
//        synchronized (playerSlap) {
//            while (playerSlap != " " && )
//        }
//
//        if (playerSlap.equals(" ")) {   // when player presses spacebar, playerSlaps() returns the time of that press.
//            result = new Date().getTime();
//        }
//        return result;
//    }

}