package models.cards;

import models.Card;
import models.GameBoard;
import models.Player;
import models.Tile;
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
        Tile selectedTile = gameBoard.getTile(tileSelection);
        if(selectedTile == null) {
            return;
        }
        int catchZZZs = player.catchZZZs(zzzs);
        selectedTile.placeZzzs(catchZZZs, false);;
    }

    @Override
    public boolean isNightmare() {
        return false;
    }
}
