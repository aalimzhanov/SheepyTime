package models;

import controllers.GameBoardController;
import controllers.PlayerController;
import views.UserInput;

public class RestingPhaseLogic {
    public void playRestingMove(GameBoardController gameBoardController, UserInput userInput, TileDeck tileDeck,
            PlayerController playerController) {
        if (gameBoardController.getNumOfDreamTiles() < 10) {
            boolean isOption1 = userInput.getRestingMoveDecision();
            if (isOption1) {
                int tileIndex = userInput.getTileSelection(tileDeck.getNumOfTiles());
                Tile selectedTile = tileDeck.getTile(tileIndex);
                int zzzs = playerController.catchZZZs(selectedTile.isInfinite() ? 1 : 3);
                selectedTile.placeZzzs(zzzs, !selectedTile.isInfinite());
                boolean isPlaced = true;
                while(isPlaced){
                    int tilePosition = userInput.getTilePlacementPosition();
                    isPlaced = gameBoardController.isTilePlaced(tilePosition);
                    gameBoardController.placeTile(tilePosition, selectedTile);  // This will display an error message if the position is occupied
                }
            } else {
                boolean onlyOneTile = userInput.getCatchZzzsDecision();
                int tileIndex = userInput.getCatchTileIndex();
                Tile selectedTile = gameBoardController.getTile(tileIndex);
                int zzzs = playerController.catchZZZs(onlyOneTile ? 2 : 1);
                selectedTile.placeZzzs(zzzs, false);
                if (!onlyOneTile) {
                    int tileIndex2 = userInput.getCatchTileIndex();
                    Tile selectedTile2 = gameBoardController.getTile(tileIndex2);
                    zzzs = playerController.catchZZZs(1);
                    selectedTile2.placeZzzs(zzzs, false);
                }
            }
        } else {
            boolean onlyOneTile = userInput.getCatchZzzsDecision();
            int tileIndex = userInput.getCatchTileIndex();
            Tile selectedTile = gameBoardController.getTile(tileIndex);
            int zzzs = playerController.catchZZZs(onlyOneTile ? 2 : 1);
            selectedTile.placeZzzs(zzzs, false);
            if (!onlyOneTile) {
                int tileIndex2 = userInput.getCatchTileIndex();
                Tile selectedTile2 = gameBoardController.getTile(tileIndex2);
                zzzs = playerController.catchZZZs(1);
                selectedTile2.placeZzzs(zzzs, false);
            }
        }
        Tile topTile = tileDeck.getTopTile();
        gameBoardController.placeTopTile(topTile);
    }
}