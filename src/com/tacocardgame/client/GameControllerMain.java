package com.tacocardgame.client;

import com.tacocardgame.controller.GameController;

import java.io.IOException;

public class GameControllerMain {
    public static void main(String[] args) {
        try {
            GameController app = new GameController();
            app.execute();  // Correctly call the execute method
        } catch (IOException e) {
            e.printStackTrace();
            // You can also include more user-friendly error handling here
        }
    }
}
