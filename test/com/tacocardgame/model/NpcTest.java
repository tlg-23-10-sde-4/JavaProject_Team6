package com.tacocardgame.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NpcTest {

    @Test
    public void getName_shouldReturnNameNpcName() {
        Player tom = new Npc("Tom", 3);
        System.out.println(tom.getName());
    }

}