import java.util.HashMap;
import java.util.Map;
public class PillowReferenceTile {
    // Key is the number of player, and the value is a reference tile.
    private Map<Integer, Map<Integer, Integer>> allReferenceTiles;
    private Map<Integer, Integer> currentReferenceTile;
    // Do we need to keep track of numOfPlayers?
    private int numOfPlayers;



    public PillowReferenceTile(int numOfPlayers){
        this.numOfPlayers = numOfPlayers;
        allReferenceTiles = new HashMap<>();
        populateTiles();
        currentReferenceTile = allReferenceTiles.get(numOfPlayers);
    }
    private void populateTiles(){
        for (int i = 0; i < 4; i++){
            Map<Integer, Integer> temp = new HashMap<>();
            allReferenceTiles.put(i, temp);
        }
    }
    public int getPlayerMoves(int placement){
        return currentReferenceTile.get(placement); 
    }
}
