package com.tacocardgame.controller;
import com.apps.util.Console;
import com.apps.util.Prompter;
import com.tacocardgame.model.*;
import com.tacocardgame.view.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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

    private void createPlayers(String playerName, int i) {  // method that creates players and player number #js
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
        Card middleCard = deck.nextCard();
        boolean gameWon = false;

        while (!gameWon) {
            for (Player currentPlayer : players) {
                String spokenWord = currentPlayer.playerSays();
                System.out.println(currentPlayer.getName() + " says: " + spokenWord);

                if (spokenWord.equalsIgnoreCase(middleCard.getName())) {
                    // Players race to slap hands on the cards
                    boolean lastPlayerSlapped = false;
                    for (Player player : players) {
                        if (player != currentPlayer) {
                            System.out.println(player.getName() + " slaps!");
                            lastPlayerSlapped = true;
                        }
                    }

                    if (!lastPlayerSlapped) {
                        System.out.println(currentPlayer.getName() + " is the last to slap!");
                        currentPlayer.addCardsToPlayerHand(deck.getMiddleStack());
                    }

                    // reset the middle stack
                    deck.clearPile();
                }
            }

            // Check if any player has won
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
}