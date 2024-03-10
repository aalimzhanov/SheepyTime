package models;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private List<Player> players;

    public ScoreBoard(List<Player> players) {
        this.players = new ArrayList<>(players);
        resetPillowPositions();
    }

    public void movePillow(Player player, int amount) {
        player.movePillow(amount);
    }

    public int getWinks(Player player) {
        return player.getWinks();
    }

    public void gainWinks(Player player, int amount) {
        player.gainWinks(amount);
    }

    public int getPillowPosition(Player player) {
        return player.getPillowPosition();
    }

    public void wakeUp(Player player) {
        player.resetWinks();
    }

    public void resetPillowPositions() {
        for (Player player : players) {
            player.resetPillowPosition();
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
            resetWinks();
            return;
        }
        // Multiplayer logic to be added
    }

    private void resetWinks() {
        for (Player player : players) {
            player.resetWinks();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
