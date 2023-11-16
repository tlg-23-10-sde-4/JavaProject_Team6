package com.tacocardgame.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void playerSays_shouldOutputCorrectResult() {
        Player player = new Player();
        System.out.println("Should print, in order: \nTACO CAT GOAT CHEESE PIZZA TACO CAT");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
    }

}