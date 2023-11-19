package com.tacocardgame.model;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class User extends Player {



    public User(String name, List playerHand) {
        setName(name);
        setPlayerHand(playerHand);
    }

//    @Override
//    public void playerChecks() {
//
//    }
//
//    @Override
//    public void playerWaits() {
//
//    }
//
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