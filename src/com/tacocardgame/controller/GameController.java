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
        Random random = new Random();       //create new instance of random obj for randomization npc
        Scanner scanner = new Scanner(System.in);

        while (!gameWon) {
            long StartTime = System.currentTimeMillis();        //records the start time for each player's turn

            for (Player currentPlayer : players) {
                String spokenWord = currentPlayer.playerSays();     //gets the word spoken by the current player
                System.out.println(currentPlayer.getName() + " says: " + spokenWord);

                if (spokenWord.equalsIgnoreCase(middleCard.getName())) {    // used to compare strings of playerSays and middle card name, ignoring case
                    // slap protocol begins
                    boolean lastPlayerSlapped = false;

                    for (Player player : players) {
                        if (player != currentPlayer) {      //TODO: create isnotNPC() in Player class, if always assigned as player 1
                            if (player.isnotNPC) {
                                System.out.println("Press the space bar to slap (any other key to skip)");
                                String userInput = scanner.nextLine();
                                if (userInput.equalsIgnoreCase(" ")) {
                                    System.out.println(player.getName() + " slaps");
                                    lastPlayerSlapped = true;
                                }
                            } else {
                                // Automated players
                                if (random.nextBoolean()) {         // have check in place and repeat until all npc players slapped
                                    System.out.println(player.getName() + " slaps!");
                                    lastPlayerSlapped = true;
                            }
                        }
                    }
                }
                    if (!lastPlayerSlapped) {
                        System.out.println(currentPlayer.getName() + " is the last to slap!");
                        long endTime = System.currentTimeMillis();      //records the end time slapped for last player calculation
                        long timeElapsed = endTime - StartTime;
                        System.out.println("Slap time for last player: " + timeElapsed + "milliseconds");
                        currentPlayer.addCardsToPlayerHand(deck.getMiddleStack());      //adds entire middle stack to player's set of cards
                    }
                    deck.clearPile();       // reset the middle stack
                }
            }
            //check if player has won
            for (Player player : players) {
                if (player.getPlayerHand().isEmpty()) { // much simpler than creating a hasNoCards() method
                    System.out.println(player.getName() + " wins the game!");   //announceWinner(); when checkCard method shows a player's cards = 0
                    gameWon = true;
                }
            }
        }
    }

    private boolean gameOver() {
        boolean result = false;

        // for-each over 'players', asking if any of them are "empty"
        for (Player player : players) {
            if (player.hasNoCards()) {
                result = true;
            }
        }
        return result;
    }

    private void welcome() {
        Console.clear();

        try {
            String welcomeBanner = Files.readString(Path.of("images/welcometo.txt"));
            String welcomeBanner2 = Files.readString(Path.of("images/tcgcp.txt"));
            prompter.info(welcomeBanner);
            prompter.info(welcomeBanner2);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Console.blankLines(2);
    }
}