package controllers;

import models.GameBoard;
import models.Player;
import models.Tile;
import views.TileView;
import views.UserInput;

public class TileController {
    private Tile tile;
    private TileView view;

    public TileController(Tile tile, TileView view) {
        this.tile = tile;
        this.view = view;
    }

    public void displayTileInfo() {
        view.displayInfo(tile);
    }

    public void activateTileEffect(Player player, GameBoard gameBoard, UserInput userInput) {
        tile.activateEffect(player, gameBoard, userInput);
    }
    public boolean isInfinite(){
        return tile.isInfinite();
    }
    public void placeZzzs(int zzzs, boolean isInfinite){
        tile.placeZzzs(zzzs, isInfinite);
    }
    public String getTileName(){
        return tile.getName();
    }
    public boolean hasZzzs(){
        return tile.hasZzzs();
    }

    public Tile getModel(){
        return tile;
    }
}

