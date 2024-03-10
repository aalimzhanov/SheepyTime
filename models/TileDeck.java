package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import controllers.TileController;

public class TileDeck {

    private Queue<TileController> allTiles;
    private List<TileController> tileMarket;

    public TileDeck() {
        allTiles = new LinkedList<>();
        tileMarket = new ArrayList<>();
    }

    public TileController getTile(int tileIndex) {
        tileIndex--;
        if (tileIndex < 0 || tileIndex >= tileMarket.size()) {
            throw new IllegalArgumentException("Invalid tile index.");
        }
        TileController chosenTile = tileMarket.remove(tileIndex);
        // Add a new tile to the market if there are any left
        if (allTiles.isEmpty()) {
            return chosenTile;
        }
        tileMarket.add(allTiles.poll());

        return chosenTile;
    }

    public void shuffleTiles() {
        List<TileController> tempList = new ArrayList<>(allTiles);
        Collections.shuffle(tempList);
        allTiles = new LinkedList<>(tempList);
    }

    public void addTile(TileController tileController) {
        allTiles.offer(tileController);
    }

    public void initializeMarket() {
        for (int i = 0; i < 4; i++) {
            tileMarket.add(allTiles.poll());
        }
    }

    public TileController getTopTile() {
        if (!allTiles.isEmpty()) {
            return allTiles.poll();
        }
        return null;
    }

    public int getNumOfTiles() {
        return tileMarket.size();
    }

    public void displayTileMarket() {
        if (getNumOfTiles() == 0)
            return;
        System.out.println("Tile Market:");
        for (int i = 0; i < getNumOfTiles(); i++) {
            System.out.print(i + 1 + " ");
            tileMarket.get(i).displayTileInfo();
        }
    }
}
