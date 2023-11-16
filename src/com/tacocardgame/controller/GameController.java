package com.tacocardgame.controller;

import java.util.Scanner;

public class GameController {
    private final Board board = Board.getInstance();
    private final BoardView boardview = new BoardView(board);
    private Deck deck = new Deck();
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private List<Player> players = new ArrayList<>();
    private final int maxID = board.maxID();


    public void execute() {
        welcomeAndPromptForHelp();
        showBoard();
        String playerName = promptForPlayerName();
        int playerCount = promptForPlayerCount();

        createPlayers(playerName, playerCount - 1);
        distributeCards();

        playGame();
    }

    private void playGame() {
        while (!gameOver()) {
            // do the thing
        }
        announceWinner();
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

    private int promptForPlayerName() {
        String name = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter your name: ");
            String input = scanner.nextLine().trim();

            if (input.matches(".*\\d.*")) {
                playerName = input;
            }
            else {
                System.out.println("Entry name should only contain letters");
            }
        }
        return playerName;
    }

    private void welcome() {
        System.out.println("              W E L C O M E  T O               ");
        System.out.println("- - - -  - - -  - - - -  - - - - - -  - - - - -");
        System.out.println("T a c o  C a t  G o a t  C h e e s e  P i z z a");
        System.out.println("- - - -  - - -  - - - -  - - - - - -  - - - - -");
    }
}