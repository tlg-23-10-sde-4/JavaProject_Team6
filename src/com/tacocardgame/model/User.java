package com.tacocardgame.model;

import com.apps.util.Prompter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.*;

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
        long maxDuration = 2510; // 2.51 seconds in milliseconds

        Prompter prompter = new Prompter(new Scanner(System.in));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> prompter.prompt("Press the space bar to slap: "));

        try {
            future.get(maxDuration, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            // Handle exceptions here
        } catch (TimeoutException e) {
            future.cancel(true); // Cancel the prompt if it exceeds the time limit
        }

        executor.shutdownNow(); // Shutdown the executor service

        long endTime = System.currentTimeMillis();
        return Math.min(endTime - startTime, maxDuration); // Return slap time, but not more than 2.51 seconds
    }
}