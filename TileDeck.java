import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TileDeck {
    
    // We don't need to create playedTiles like we did in Deck class, since there can only be 10 played tiles in a round, 
    // and we have more tiles in total
    private Queue<Tile> allTiles;
    private List<Tile> tileMarket;

    public TileDeck(){
        allTiles = new LinkedList<>();
        tileMarket = new ArrayList<>();
    }
    public Tile getTile(int index){
        Tile returnTile = tileMarket.get(index);
        tileMarket.set(index, allTiles.poll());
        return returnTile;
    }
    public void shuffleTiles(){
        List<Tile> tempList = new LinkedList<>(allTiles);
        Collections.shuffle(tempList);
        allTiles.clear();
        while(!tempList.isEmpty()){
            allTiles.offer(tempList.remove(0));
        }
    }
}
