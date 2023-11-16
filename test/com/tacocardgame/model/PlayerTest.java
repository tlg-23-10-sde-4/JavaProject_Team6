package com.tacocardgame.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void playerSays_shouldOutputCorrectResult() {
        Player player = new Player();
        System.out.println("Should print, in order: Taco, Cat, Goat, Cheese, Pizza, Taco, Cat");
        System.out.println(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
        System.out.print(Player.playerSays() + " ");
    }

}