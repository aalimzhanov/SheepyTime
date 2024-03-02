import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {
    private Map<Player, Integer> playerScores;
    private Map<Player, Integer> pillowPositions;

    public ScoreBoard() {
        playerScores = new HashMap<>();
        pillowPositions = new HashMap<>();
    }

    public void movePillow(Player player, int amount) {
        if (pillowPositions.containsKey(player)) {
            int newPosition = pillowPositions.get(player) + amount;
            pillowPositions.put(player, newPosition);

        } else {
            throw new IllegalArgumentException("This player is not on the scoreboard");
        }
    }
    public void gainWinks(Player player, int amount) {
        if (pillowPositions.containsKey(player)) {
            int newScore = playerScores.get(player) + amount;
            playerScores.put(player, newScore);
        } else {
            throw new IllegalArgumentException("This player is not on the scoreboard");
        }
    }

    // Add or reset player to the scoreboard
    public void resetPlayer(Player player, int pillowPosition) {
        playerScores.put(player, 0);
        pillowPositions.put(player, pillowPosition);
    }
}
