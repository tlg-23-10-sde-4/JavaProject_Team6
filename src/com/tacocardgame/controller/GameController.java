package com.tacocardgame.controller;
import com.apps.util.Console;
import com.apps.util.Prompter;
import com.tacocardgame.model.Deck;
import com.tacocardgame.model.Player;
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


    public GameController(Deck deck, List<Player> players) {
        this.deck = deck;
        this.players = players;
    }

    public void execute() {
        welcomeAndPromptForHelp();
        String playerName = promptForPlayerName();
        int playerCount = promptForPlayerCount();

        createPlayers(playerName, playerCount - 1);
        distributeCards();

        playGame();
    }

    private void distributeCards() {   // method that distributes cards to players from Deck #js
    }

    private void createPlayers(String playerName, int i) {  // method that creates players and player number #js
        Player player = new Player();
        player.setName(playerName);
        players.add(player);  // still need method for player.add; #js
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

    private void playGame() {
        while (!gameOver()) {
            // do the thing
        }
        //announceWinner();  // when checkCard method shows a player's cards = 0
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