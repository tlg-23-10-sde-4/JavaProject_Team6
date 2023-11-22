package com.tacocardgame.model;

import com.apps.util.Prompter;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
    public Long playerSlaps() {
        long startTime = System.currentTimeMillis();
        long maxDuration = 3000; // 3 seconds (in ms)

        Scanner scanner = new Scanner(System.in);
        Prompter prompter = new Prompter(scanner);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> prompter.prompt("Press the space bar to slap: "));

        try {
            String userInput = future.get(maxDuration, TimeUnit.MILLISECONDS);
            if (!userInput.equals(" ")) throw new InputMismatchException("Invalid input. User must press space bar to slap.");
        } catch (InterruptedException | ExecutionException e) {
            // Handle exceptions here
        } catch (TimeoutException e) throws new TimeoutException("Time limit exceeded. Slap faster!");
            future.cancel(true);
        }

        executor.shutdownNow(); // Shutdown the executor service

        long endTime = System.currentTimeMillis();
        return Math.min(endTime - startTime, maxDuration); // Return slap time, but not more than 3 seconds
    }
}