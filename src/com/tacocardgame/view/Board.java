package com.tacocardgame.view;

import com.tacocardgame.model.Player;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Board implements Serializable {
    private static final String dataFilePath = "C:\\Users\\KPerk\\OneDrive\\Desktop\\G6 Project\\new13.txt";  //REPLACE WITH ACTUAL FILE

    public static Board getInstance() {
        Board board = null;

        if (Files.exists(Path.of(dataFilePath))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (Board) in.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            board = new Board();
        }
        return board;
    }

    private final Map<Integer, String> idMap = loadPlayerIdMap();
    private final Map<Integer, Player> playerMap = new TreeMap<>();

    // prevent instantiation from outside, it's only done in here (in getInstance() method)
    private Board() {
    }

    /*
     * Updates the board (playerMap)
     *
     * This could mean fetching an existing Player from playerMap (id is in the map),
     * or we might need to create a new Player (id is not in the map),
     * then we need to put that new Player in the map.
     */

    public void updateName(String playerName) {

        if (playerMap.containsValue(playerName)) { // name present, so grab playerName
            for (Map.Entry<Integer, Player> entry : playerMap.entrySet()) {
                if (entry.getValue().getName().equals(playerName)) {
                    Player player = entry.getValue();
                    }
            }
        } else { // name isn't present, so create a new Player
            int newPlayerId = idMap.size() + 1;
            Player newPlayer = new Player(playerName, newPlayerId);
            playerMap.put(newPlayerId, newPlayer); // Add the new player to the map
        }
        save();
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

    public int maxId () {
            return idMap.size();
    }

    private Map<Integer, String> loadPlayerIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        try {
            // Read all lines from the specified file path into a List<String>
            List<String> lines = Files.readAllLines(Path.of("C:\\Users\\KPerk\\OneDrive\\Desktop\\G6 Project\\new13.txt"));  // REPLACE WITH ACTUAL FILE NAME

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
