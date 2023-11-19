package com.tacocardgame.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getName_shouldReturnNameUserName() {
        User tom = new User("Tom", 3);
        System.out.println(tom.getName());
    }

}