package com.tacocardgame.view;

import com.tacocardgame.model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Board implements Serializable {
    private static final String dataFilePath = "resources/images/welcome-A; // REPLACE WITH ACTUAL FILE

    public static Board getInstance() {
        Board board = null;

        if (Files.exists(Path.of(dataFilePath))) {      //checks if the data file exists.  if it does, deserialize the Board obj
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (Board) in.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {    //if no data file, creates a new Board instance
            board = new Board();
        }
        return board;
    }

    private final Map<Integer, String> idMap = loadPlayerIdMap();       //map to store player IDs and names
    private final Map<Integer, Player> playerMap = new TreeMap<>();     //map to store IDs and Player objects

    // prevent instantiation from outside, it's only done in here (in getInstance() method)
    private Board() {
    }

    /*
     * Updates the board (playerMap)
     *
     * Updates the playerMap based on whether the given playerName is present or not.
     * If playerName is already in playerMap, it grabs the existing Player object.
     * If playerName is not present, it creates a new Player and adds it to playerMap.
     *
     */

    public void updateName(String playerName) {
        if (playerMap.containsValue(playerName)) { // name present; grab playerName
            for (Map.Entry<Integer, Player> entry : playerMap.entrySet()) {
                if (entry.getValue().getName().equals(playerName)) {
                    Player player = entry.getValue();
                }
            }
        } else { // name isn't present; create a new Player
            int newPlayerId = idMap.size() + 1;
            Player newPlayer = new Player(playerName, newPlayerId);
            playerMap.put(newPlayerId, newPlayer); // Add the new player to the map
        }
        save();     //saves updated Board obj to data file
    }

    /*
     * Writes *this* Board object to a binary file data/board.dat
     * Uses built-in Java object serialization facility
     */

    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            out.writeObject(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Collection<Player> getPlayers() {
        return playerMap.values();
    }

    private Map<Integer, String> loadPlayerIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        try {
            // read all lines from the specified file path into a List<String>
            List<String> lines = Files.readAllLines(Path.of("C:\\Users\\KPerk\\OneDrive\\Desktop\\G6 Project\\new13.txt")); // REPLACE WITH ACTUAL FILE NAME

            // For each line, split it into "tokens," i.e., "1,Player1" is split into "1" and "Player1"
            for (String line : lines) {
                String[] tokens = line.split(",");
                if (tokens.length == 2) {
                    int playerId = Integer.parseInt(tokens[0]);
                    String playerName = tokens[1];
                    idMap.put(playerId, playerName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idMap;
    }
}