package com.tacocardgame.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.tacocardgame.model.*;
import com.tacocardgame.view.BoardView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class GameController {
    private Deck deck;
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private List<Player> players;
    private Pile pile;
    private Player winner;
    private BoardView boardView;

    public GameController() throws IOException {
        this.deck = new Deck();
        this.players = new ArrayList<>();
        this.pile = new Pile();
        this.boardView = new BoardView();

        BoardView boardView = new BoardView();
        boardView.show(players); // Assuming 'players' is your List<Player>

        // Initialize players here
        players.add(new User("User", 1)); // User player
        players.add(new Npc("Chuck", 2)); // NPC players
        players.add(new Npc("CJ", 3));
        players.add(new Npc("Justin", 4));
        players.add(new Npc("Keith", 5));
    }


    public void execute() throws IOException {
        Console.clear();
        this.displayWelcomeSequence();
        String userPlayerName = promptForPlayerName();
        // sets the one user
        players.get(0).setName(userPlayerName);
        deck.distributeCards(players);  //distribute cards evenly amongst players
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
        int currentPlayerIndex = 0;

        while (!gameWon) {
            Player currentPlayer = players.get(currentPlayerIndex);
            Card flippedCard = currentPlayer.takeTurn(pile);

            // Check for a match and handle slap if necessary
            if (flippedCard.getType().getLabel().equalsIgnoreCase(Objects.requireNonNull(CardType.findByPosition(currentPlayerIndex)).getLabel())) {
                handleSlap();
            }

            // Check if the game is won
            gameWon = currentPlayer.getPlayerHand().isEmpty();

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();

        }

        // Announce winner
        Player winner = players.get((currentPlayerIndex - 1 + players.size()) % players.size());
        System.out.println("Game Over! The winner is " + winner.getName());
    }


    private void handleSlap() {
        System.out.println("Match found! Players prepare to slap!");
        Console.pause(2000); // 2 seconds pause

        // Collect slap times from each player
        List<Long> slapTimes = new ArrayList<>();
        for (Player player : players) {
            slapTimes.add(player.playerSlaps());
        }

        Player lastToSlap = determineLastToSlap(slapTimes);
        lastToSlap.addCardsToPlayerHand(pile.dequeToArrayList());
        pile.clearPile();

        boardView.showLoser(lastToSlap); // Show loser on the board view
    }

    private Player determineLastToSlap(List<Long> slapTimes) {
        long maxTime = Collections.max(slapTimes);
        int lastIndex = slapTimes.indexOf(maxTime);
        return players.get(lastIndex);
    }


}




