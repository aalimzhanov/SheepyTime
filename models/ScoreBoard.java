package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {
    private List<Player> players;
    private Map<Player, Integer> pillowPositions;

    public ScoreBoard(List<Player> players) {
        this.players = new ArrayList<>(players);
        pillowPositions = new HashMap<>();
        resetPillowPositions();
    }

    public void movePillow(Player player, int amount) {
        pillowPositions.merge(player, amount, Integer::sum);
    }

    public int getWinks(Player player) {
        return player.getWinks();
    }

    public void gainWinks(Player player, int amount) {
        player.gainWinks(amount);
    }

    public int getPillowPosition(Player player) {
        return pillowPositions.get(player);
    }

    public void wakeUp(Player player) {
        player.resetWinks();
    }

    public void resetPillowPositions() {
        pillowPositions.clear();
        for (Player player : players) {
            pillowPositions.put(player, 40);
        }
    }

    public boolean isGameOver() {
        if (players.size() == 1) {
            Player player = players.get(0);
            return getPillowPosition(player) <= getWinks(player);
        }
        return false; // logic to be added for multiplayer
    }

    public void endOfTurn() {
        if (players.size() == 1) {
            Player player = players.get(0);
            int winks = getWinks(player);
            movePillow(player, -winks / 5);
            resetScores();
            return;
        }
        // Multiplayer logic to be added
    }

    private void resetScores() {
        for (Player player : players) {
            player.resetWinks();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
