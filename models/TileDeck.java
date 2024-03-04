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

    public Tile getTile(int index) {
        Tile returnTile = tileMarket.get(index);
        tileMarket.set(index, allTiles.poll());
        return returnTile;
    }

    public void shuffleTiles() {
        List<Tile> tempList = new ArrayList<>(allTiles);
        Collections.shuffle(tempList);
        allTiles = new LinkedList<>(tempList);
    }

    public void addTile(Tile tile) {
        allTiles.offer(tile);
    }

    public List<Tile> getTileMarket() {
        return tileMarket;
    }

    public Tile getTopTile() {
        if (!allTiles.isEmpty()) {
            return allTiles.poll();
        }
        for (Tile tile : allTiles) {
            if (tile != null) {
                return tile;
            }
        }
        return null;
    }
}
