package com.tacocardgame.model;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class User extends Player {


    // TODO: we have a mismatch here between this constructor and the Player constructor which has id
    public User(String name, List playerHand) {
        setName(name);
        setPlayerHand(playerHand);
    }

    // intent is to capture the exact time of the user's slap (pressing spacebar) for comparison to the Npc Players
    @Override
    public Date playerSlaps() {
        Date result = null;
        Scanner playerSlap = new Scanner(System.in);
        if (playerSlap.equals(" ")) {   // when player presses spacebar, playerSlaps() returns the time of that press.
            result = new Date();
        }
        return result;
    }





}