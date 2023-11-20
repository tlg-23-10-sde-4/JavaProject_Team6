package com.tacocardgame.view;

import com.tacocardgame.model.*;
import java.util.Collection;

public class BoardView {
    private final Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void show() {
        Collection<Player> players = board.getPlayers();

        // Title and headings
        StringBuilder display = new StringBuilder();
        display.append("\nPlayer Information\n");
        display.append("========================\n");
        display.append("\n");
        display.append("Player Name      #ofCards\n");
        display.append("-----------        ----\n");

        // Player information
        if (players.isEmpty()) {
            display.append("\nThere are currently no players to show\n");
        } else {
            for (Player player : players) {
                String row = String.format("%-15s %4d\n",
                        player.getName(), player.getPlayerHand().size());
                display.append(row);
            }
        }
    }
}
