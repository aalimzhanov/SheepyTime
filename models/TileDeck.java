package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TileDeck {

    private Queue<Tile> allTiles;
    private List<Tile> tileMarket;

    public TileDeck() {
        allTiles = new LinkedList<>();
        tileMarket = new ArrayList<>();
    }

    
    
    public Tile getTile(int tileIndex) {
        tileIndex--;
        if (tileIndex < 0 || tileIndex >= tileMarket.size()) {
            throw new IllegalArgumentException("Invalid tile index.");
        }
        Tile chosenTile = tileMarket.remove(tileIndex);
        // Add a new tile to the market if there are any left
        if (allTiles.isEmpty()) {
            return chosenTile;
        }
        tileMarket.add(allTiles.poll());

        return chosenTile;
    }

    public void shuffleTiles() {
        List<Tile> tempList = new ArrayList<>(allTiles);
        Collections.shuffle(tempList);
        allTiles = new LinkedList<>(tempList);
    }

    public void addTile(Tile tile) {
        allTiles.offer(tile);
    }

    public void initializeMarket() {
        for (int i = 0; i < 4; i++) {
            tileMarket.add(allTiles.poll());
        }
    }

    public Tile getTopTile() {
        if (!allTiles.isEmpty()) {
            return allTiles.poll();
        }
        return null;
    }

    public int getNumOfTiles(){
        return tileMarket.size();
    }
}
