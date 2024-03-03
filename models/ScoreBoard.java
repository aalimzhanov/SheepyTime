package models;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ScoreBoard {
    private Map<String, Integer> playerScores;
    private Map<String, Integer> pillowPositions;
    private int numOfPlayers;
    private final int WAKE_UP = -1; 
    public ScoreBoard(List<String> playerNames) {
        playerScores = new HashMap<>();
        pillowPositions = new HashMap<>();
        initializePillows(playerNames);
        numOfPlayers = playerNames.size();
    }
    private void initializePillows(List<String> playerNames) {
        playerNames.forEach(player -> {
            playerScores.put(player, 0);
            pillowPositions.put(player, 40);
        });
    }

    public void movePillow(String playerName, int amount) {
        if (pillowPositions.containsKey(playerName)) {
            pillowPositions.merge(playerName, amount, Integer::sum);
        } else {
            throw new IllegalArgumentException("This player is not on the scoreboard");
        }
    }
    public void gainWinks(String playerName, int amount) {
        if (pillowPositions.containsKey(playerName)) {
            playerScores.merge(playerName, amount, Integer::sum);
        } else {
            throw new IllegalArgumentException("This player is not on the scoreboard");
        }
    }
    public void wakeUp(String playerName) {
        if (playerScores.containsKey(playerName)) {
            playerScores.put(playerName, WAKE_UP);
        } else {
            throw new IllegalArgumentException("This player is not on the scoreboard");
        }
    }

    public int getScore(String playerName) {
        if (playerScores.containsKey(playerName)) {
            return playerScores.get(playerName);
        } else {
            throw new IllegalArgumentException("This player is not on the scoreboard");
        }
    }
    public int getPillowPosition(String playerName) {
        if (pillowPositions.containsKey(playerName)) {
            return pillowPositions.get(playerName);
        } else {
            throw new IllegalArgumentException("This player is not on the scoreboard");
        }
    }
    public void endOfTurn(){
        if(numOfPlayers == 1){
            // gain 1 pillow for every 5 winks
            String player1 = playerScores.keySet().iterator().next();
            int score = playerScores.get(player1);
            movePillow(player1, -score/5);
            resetScores();
            return;
        }
        multiPlayerEndOfTurn();
        resetScores();
    }
    private void multiPlayerEndOfTurn(){
        // Sort the map and store it as a list of entries
        List<Map.Entry<String, Integer>> sortedEntries = playerScores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < sortedEntries.size(); i++) {
            Map.Entry<String, Integer> entry = sortedEntries.get(i);
            String player = entry.getKey();
            int score = entry.getValue();
            
            if (score == WAKE_UP) {
                // Move pillow 3 spaces back
                movePillow(player, -3); 
            } else {
                // Need to modify this for the next milestone to account for players having the same score 
                int gain = switch (numOfPlayers) {
                    // 2 players: move 8 spaces back for 1st, 5 spaces back for 2nd
                    case 2 -> (i == 0) ? -8 : -5;
                    // 3 players: move 10 spaces back for 1st, 7 spaces back for 2nd, 5 spaces back for 3rd
                    case 3 -> (i == 0) ? -10 : (i == 1) ? -7 : -5;
                    // 4 players: move 10 spaces back for 1st, 8 spaces back for 2nd, 6 spaces back for 3rd, 5 spaces back for 4th
                    case 4 -> (i == 0) ? -10 : (i == 1) ? -8 : (i == 2) ? -6 : -5;
                    default -> 0;
                };
                movePillow(player, gain);
            }
        }
    }
    private void resetScores() {
        playerScores.keySet().forEach(player -> playerScores.put(player, 0));
    }
    public Set<String> getPlayerNames(){
        return playerScores.keySet();
    }
    public boolean isGameOver(){
        if (numOfPlayers == 1) {
            Map.Entry<String, Integer> scoreEntry = playerScores.entrySet().iterator().next();
            Map.Entry<String, Integer> pillowEntry = pillowPositions.entrySet().iterator().next();

            return scoreEntry.getValue() >= pillowPositions.get(pillowEntry.getKey());
        } 
        return multiPlayerGameOver();
    }
    private boolean multiPlayerGameOver(){
        // Need to modify for the next milestone to account for players having the same score
        return playerScores.entrySet().stream().anyMatch(entry -> entry.getValue() >= pillowPositions.get(entry.getKey()));
    }
}
