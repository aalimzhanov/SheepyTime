package controllers;

import models.GameBoard;
import models.Player;
import tiles.Tile;
import views.TileView;

public class TileController {
    private Tile tile;
    private TileView view;

    public TileController(Tile tile, TileView view){
        this.tile = tile;
        this.view = view;
    }

    public void displayTileInfo(){
        view.displayInfo(tile);
    }

    public void activateTileEffect(Player player, GameBoard gameBoard){
        tile.activateEffect(player, gameBoard);
    }
}
