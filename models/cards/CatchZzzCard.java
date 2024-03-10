package models.cards;

import controllers.TileController;
import models.Card;
import models.GameBoard;
import models.Player;
import views.UserInput;

public class CatchZzzCard implements Card {
    private int zzzs;

    public CatchZzzCard(int zzzs) {
        this.zzzs = zzzs;
    }

    @Override
    public String getInformation() {
        return "Catch " + zzzs + (zzzs == 1 ? " zzz" : " zzzs");
    }

    @Override
    public void executeAction(Player player, GameBoard gameBoard, UserInput input) {
        int tileSelection = input.getCatchTileIndex();
        if(!gameBoard.isTilePlaced(tileSelection)) return;
        TileController selectedTile = gameBoard.getTile(tileSelection);
        int catchZZZs = player.catchZZZs(zzzs);
        selectedTile.placeZzzs(catchZZZs, false);;
    }

    @Override
    public boolean isNightmare() {
        return false;
    }
}
