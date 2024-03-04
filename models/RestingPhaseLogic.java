package models;

import controllers.GameBoardController;
import views.UserInput;

public class RestingPhaseLogic {
    public void playRestingMove(GameBoardController gameBoardController, UserInput userInput, TileDeck tileDeck,
            Player player) {
        if (gameBoardController.getNumOfDreamTiles() < 10) {
            boolean isOption1 = userInput.getRestingMoveDecision();
            if (isOption1) {
                int tileIndex = userInput.getTileSelection();
                Tile selectedTile = tileDeck.getTile(tileIndex);
                int zzzs = player.catchZZZs(selectedTile.isInfinite() ? 1 : 3);
                selectedTile.placeZzzs(zzzs, !selectedTile.isInfinite());
            } else {
                boolean onlyOneTile = userInput.getCatchZzzsDecision();
                int tileIndex = userInput.getCatchTileIndex();
                Tile selectedTile = tileDeck.getTile(tileIndex);
                int zzzs = player.catchZZZs(onlyOneTile ? 2 : 1);
                selectedTile.placeZzzs(zzzs, false);
                if (!onlyOneTile) {
                    int tileIndex2 = userInput.getCatchTileIndex();
                    Tile selectedTile2 = tileDeck.getTile(tileIndex2);
                    zzzs = player.catchZZZs(1);
                    selectedTile2.placeZzzs(zzzs, false);
                }
            }
        } else {
            boolean onlyOneTile = userInput.getCatchZzzsDecision();
            int tileIndex = userInput.getCatchTileIndex();
            Tile selectedTile = tileDeck.getTile(tileIndex);
            int zzzs = player.catchZZZs(onlyOneTile ? 2 : 1);
            selectedTile.placeZzzs(zzzs, false);
            if (!onlyOneTile) {
                int tileIndex2 = userInput.getCatchTileIndex();
                Tile selectedTile2 = tileDeck.getTile(tileIndex2);
                zzzs = player.catchZZZs(1);
                selectedTile2.placeZzzs(zzzs, false);
            }
        }
        Tile topTile = tileDeck.getTopTile();
        gameBoardController.placeTopTile(topTile);
    }
}