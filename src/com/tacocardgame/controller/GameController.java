package com.tacocardgame.controller;

public class GameController {
    private Deck deck = new Deck();
    private Prompter prompter = new Prompter(new Scanner(System.in));

    private List<Player> players = new ArrayList<>();


    public void execute() {
        welcomeAndPromptForHelp();
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
}
}