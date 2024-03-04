package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TileDeck {
    
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
        List<Tile> tempList = new ArrayList<>(allTiles);
        Collections.shuffle(tempList);
        allTiles = new LinkedList<>(tempList);
    }
}
