package controllers;

import models.Player;
import models.TimeParser;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TurnManager {
    private List<Player> players;
    private int currentPlayerIndex;

    public TurnManager() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = -1; // No current player at the start
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        if (!players.isEmpty()) {
            determineFirstTurn();
        }
    }

    public void nextTurn() {
        if (!players.isEmpty()) {
            // Cycle through the players
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    // Returns the player whose turn is currently active
    public Player getCurrentPlayer() {
        if (currentPlayerIndex >= 0) {
            return players.get(currentPlayerIndex);
        }
        return null; // No current player if index is -1
    }

    // Optional: Resets the game to its initial state
    public void resetGame() {
        determineFirstTurn();
    }

    public void determineFirstTurn(){
        if (players.isEmpty()) {
            return;
        }
        if (players.size() == 1) {
            currentPlayerIndex = 0;
            return;
        }

        // Logic for determining the first player in multiplayer games
        // Need to modify (23:55 is earlier than 00:05, but 00:05 is earlier than 23:55 in this implementation)
        Player earliestPlayer = players.stream()
            .min(Comparator.comparing(player -> TimeParser.parseSleepTime(player.getSleepTime())))
            .orElse(null);

        if (earliestPlayer != null) {
            currentPlayerIndex = players.indexOf(earliestPlayer);
        }
    }
}
