package com.tacocardgame.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.tacocardgame.model.*;
import com.tacocardgame.view.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameController {
    private Deck deck = new Deck();
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private List<Player> players = new ArrayList<>();


    public GameController(Deck deck, List<Player> players) throws IOException {
        this.deck = deck;
        this.players = players;
    }

    public void execute() {
        welcomeAndPromptForHelp();
        String playerName = promptForPlayerName();
        int playerCount = promptForPlayerCount();

        createPlayers(playerName, playerCount - 1);

        distributeCards();  //distribute cards evenly amongst players
        playGame();
    }

    private void distributeCards() {   // method that distributes cards to players from Deck #js
    }

    private void createPlayers(String playerName, int i) {  // method that creates players and player number #js  //does i return npc count?
        Player player = new Player();
        player.setName(playerName);
        players.add(player);  // still need method for player.add; #js //updateName in Board #kp
    }


    private void welcomeAndPromptForHelp() {
        //SOUT with playerName from player.name() and ask if you want further instructions #js
        //if no, proceed to start screen #js
        //if yes, sout message: String welcomeBanner = Files.readString(Path.of("images/gameRules.txt"));

    }

    private String promptForPlayerName() {
        String playerName = prompter.prompt("Please enter your name: ");
        return playerName;
    }

    private int promptForPlayerCount() {
        int playerCount = Integer.parseInt(prompter.prompt("How many players would you like to play? "));
        return playerCount;
    }

    /*
     *  Below is generic map of playGame().  Time during slap environment needs to be added.
     *  Maybe look at System.currentTimeMillis() for round timing???
     */

    private void playGame() {
        Card middleCard = deck.nextCard();  //draws the first card(top card) from the deck
        boolean gameWon = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameWon) {
            long roundStartTime = System.currentTimeMillis();        //records the start time for each player's turn
            ExecutorService executorService = Executors.newCachedThreadPool();  //managing slap threads
            Player lastSlapPlayer = null;

            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get(i);
                String wordSpoken = currentPlayer.playerSays();     //gets the word spoken by the current player
                System.out.println(currentPlayer.getName() + " says: " + wordSpoken);

                if (wordSpoken.equalsIgnoreCase(middleCard.getType().getLabel())) {    // used to compare strings of playerSays and middle card name, ignoring case
                // slap protocol begins
                    boolean playerSlapped = false;

                    for (Player player : players) {

                        if (player != currentPlayer) {
                            //TODO: create isHuman() in Player class, * PLAYERID
                            if (!player.isHuman()) {        //NPC actions
                                executorService.submit(() -> {
                                    Random random = new Random();
                                    int npcSlapDelay = random.nextInt(2000);     //random delays between 0-2000ms

                                    try {
                                        Thread.sleep(npcSlapDelay);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println(player.getName() + "slaps");
                                    playerSlapped = true;
                                });
                            } else {        //human actions
                                    System.out.println("Press the space bar to slap (any other key to skip)");      //RETURNS 0 *BUG*  KP
                                    String userInput = scanner.nextLine();
                                    if (userInput.equals(" ")) {
                                    System.out.println(player.getName() + " slaps");
                                    playerSlapped = true;
                                    }
                            //     (random.nextBoolean())  maybe use for npc decision making process for slaps?
                    }
                    if (!playerSlapped) {
                        System.out.println(currentPlayer.getName() + " is the last to slap!");
                        long endTime = System.currentTimeMillis();      //records the end time slapped for last player calculation
                        long timeElapsed = endTime - roundStartTime;
                        System.out.println("Slap time for last player: " + timeElapsed + "milliseconds");
                    }
                    Pile.clearPile();       // reset the middle stack
                }
            }

            //check if player has won
                    if (lastSlapPlayer != null) {
                        lastSlapPlayer.addCardsToPlayerHand(Pile.getMiddleStack()); //TODO: getMiddleStack() or identify () in Pile Adds the entire middle stack to the last slapped player's set of cards
                if (Player.getPlayerHand().isEmpty()) { // much simpler than creating a hasNoCards() method
                    System.out.println(Player.getName() + " wins the game!");   //announceWinner(); when checkCard method shows a player's cards = 0
                    gameWon = true;
                }
            }

            executorService.shutdown();
        }
    }

//    private boolean gameOver() {
//        boolean result = false;
//
//        // for-each over 'players', asking if any of them are "empty"
//        for (Player player : players) {
//            if (player.hasNoCards()) {
//                result = true;
//            }
//        }
//        return result;
//    }

    private void welcome() {
        Console.clear();

        try {
            String welcomeBanner = Files.readString(Path.of("images/welcometo.txt"));
            String welcomeBanner2 = Files.readString(Path.of("images/tcgcp.txt"));
            prompter.info(welcomeBanner);
            prompter.info(welcomeBanner2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Console.blankLines(2);
    }
}