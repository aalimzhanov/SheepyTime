package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {
    private List<Player> players;
    private Map<Player, Integer> pillowPositions;

    public ScoreBoard(List<Player> players) {
        this.players = players;
        pillowPositions = new HashMap<>();
        players.forEach(player -> {
            pillowPositions.put(player, 40);
        });
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
        players.forEach(player -> {
            pillowPositions.put(player, 40);
        });
    }

    public boolean isGameOver() {
        if(players.size() == 1) {
            return pillowPositions.get(players.get(0)) <= players.get(0).getWinks();
        }
        return false;   // logic to be added for multiplayer
    }

    public void endOfTurn() {
        if (players.size() == 1) {
            // gain 1 pillow for every 5 winks
            int winks = players.get(0).getWinks();
            movePillow(players.get(0), -winks / 5);
            resetScores();
            return;
        }
        // Multiplayer logic to be added
    }


    private void resetScores() {
        players.forEach(player -> {
            player.resetWinks();
        });
    }

    public List<Player> getPlayers() {
        return players;
    }

}
