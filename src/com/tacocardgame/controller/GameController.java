package com.tacocardgame.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.tacocardgame.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameController {
    private Deck deck;
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private List<Player> players;
    private Pile pile;


    public GameController() throws IOException {
        this.deck = new Deck();
        this.players = new ArrayList<>();
        this.pile = Pile();

        // Initialize players here
        players.add(new Player("User", 1)); // User player
        players.add(new Player("Chuck", 2)); // NPC players
        players.add(new Player("CJ", 3));
        players.add(new Player("Justin", 4));
        players.add(new Player("Keith", 5));
    }


    public void execute() throws IOException {
        displayWelcomeSequence();
        String userPlayerName = promptForPlayerName();
        // sets the one user
        players.get(0).setName(userPlayerName);
        distributeCards();  //distribute cards evenly amongst players
        playGame();
    }


    private void displayWelcomeSequence() throws IOException {
        List<String> welcomeImages = loadWelcomeImages();
        for (String image : welcomeImages) {
            Console.clear();
            System.out.println(image);
            try {
                Thread.sleep(500); // display each image for 0.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Console.clear();
    }

    private List<String> loadWelcomeImages() throws IOException {
        List<String> images = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            String file = "resources/images/welcome-" + i + ".txt";
            images.add(Files.readString(Path.of(file)));
        }
        return images;
    }

    private String promptForPlayerName() {
        String playerName = prompter.prompt("Please enter your name: ");
        return playerName;
    }

    public void playGame() {
        boolean gameWon = false;
        Prompter prompter = new Prompter(new Scanner(System.in));

        while (gameWon) {       //gameWon default is false, meaning game NOT won
            long roundStartTime = System.currentTimeMillis();        //records the start time for each player's turn
            ExecutorService executorService = Executors.newCachedThreadPool();  //managing slap threads
            Player lastPlayerToSlap = null;

            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get(i);
                String playerStatement = currentPlayer.playerSays();     //gets the word spoken by the current player //
                System.out.println(currentPlayer.getName() + " says: " + playerStatement);

                if (playerStatement.equalsIgnoreCase(middleCard.getType().getLabel())) {    // used to compare strings of playerSays and middle card name, ignoring case
                    // slap protocol begins
                    boolean playerSlapped = false;

                    for (Player player : players) {
                        currentPlayer.takeTurn();

                        if (player != currentPlayer) {
                            /*playerid=1 or not*/
                            //assuming player 1 is only human user, create isUser() in Player class, * PLAYERID
                            if (player.getPlayerId()!= 1) {        // keith, what are the properties of a player that is not a NPC?
                                // As in, what would their playerID be? you can define isUser() this way.  #JS 20NOV 1212
                                executorService.submit(() -> {
                                    Random random = new Random();
                                    int npcSlapDelay = random.nextInt(2000);     //random delays between 0-2000ms   //hardcode testing who wins every single time.

                                    try {
                                        Thread.sleep(npcSlapDelay);     //slap delay intro
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println(player.getName() + "slaps");
                                    playerSlapped = true;
                                });
                            } else {        //human actions

                                String userSlapResult = User.userSlaps();
                                System.out.println(userSlapResult);

                            }
                            if (!playerSlapped) {
                                System.out.println(currentPlayer.getName() + " is the last to slap!");
                                long endTime = System.currentTimeMillis();      //records the end time slapped for last player calculation
                                long timeElapsed = endTime - roundStartTime;
                                System.out.println("Slap time for last player: " + timeElapsed + "milliseconds");
                                Player.addCardsToPlayerHand;
                            }

                        }
                    }

                    //check if player has won
                    if (lastPlayerToSlap != null) {
                        lastPlayerToSlap.addCardsToPlayerHand(Player.getPlayerHand()); //TODO: getMiddleStack() or identify () in Pile Adds the entire middle stack to the last slapped player's set of cards
                        if (Player.getPlayerHand().isEmpty()) { // KP: much simpler than creating a hasNoCards() method  #JS- Fact.
                            System.out.println(Player.getName() + " wins the game!");   //announceWinner(); when checkCard method shows a player's cards = 0
                            gameWon = true;
                        }
                    }

                    executorService.shutdown();
                }
            }
        }
    }
}


//    private void welcome() {
//        Console.clear();
//
//        try {
//            String welcomeBanner = Files.readString(Path.of("images/welcometo.txt"));
//            String welcomeBanner2 = Files.readString(Path.of("images/tcgcp.txt"));
//            prompter.info(welcomeBanner);
//            prompter.info(welcomeBanner2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Console.blankLines(2);
//    }
