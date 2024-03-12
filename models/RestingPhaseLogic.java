package models;

import controllers.GameBoardController;
import controllers.PlayerController;
import controllers.TileController;
import views.UserInput;

/**
 * This class represents the logic for the resting phase of the game.
 * It contains methods for playing the resting move and handling the placement of tiles.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class RestingPhaseLogic {

    /**
     * Plays the resting move in the game.
     *
     * @param gameBoardController The game board controller.
     * @param userInput          The user input.
     * @param tileDeck           The tile deck.
     * @param playerController   The player controller.
     */
    public void playRestingMove(GameBoardController gameBoardController, UserInput userInput, TileDeck tileDeck,
                                PlayerController playerController) {
        if (gameBoardController.getNumOfDreamTiles() < 10) {
            tileDeck.displayTileMarket();
            boolean isOption1 = userInput.getRestingMoveDecision();
            if (isOption1) {
                int tileIndex = userInput.getTileSelection(tileDeck.getNumOfTiles());
                TileController selectedTile = tileDeck.getTile(tileIndex);
                int zzzs = playerController.catchZZZs(selectedTile.isInfinite() ? 1 : 3);
                selectedTile.placeZzzs(zzzs, !selectedTile.isInfinite());
                boolean isPlaced = true;
                while (isPlaced) {
                    int tilePosition = userInput.getTilePlacementPosition();
                    isPlaced = gameBoardController.isTilePlaced(tilePosition);
                    gameBoardController.placeTile(tilePosition, selectedTile);  // This will display an error message if the position is occupied
                }
            } else {
                boolean onlyOneTile = userInput.getCatchZzzsDecision();
                int tileIndex = userInput.getCatchTileIndex();
                TileController selectedTile = gameBoardController.getTile(tileIndex);
                if(selectedTile == null){
                    System.out.println("No tile in this position");
                }
                else{
                    int zzzs = playerController.catchZZZs(onlyOneTile ? 2 : 1);
                    selectedTile.placeZzzs(zzzs, false);
                }
                if (!onlyOneTile) {
                    int tileIndex2 = userInput.getCatchTileIndex();
                    TileController selectedTile2 = gameBoardController.getTile(tileIndex2);
                    if (selectedTile2 == null) {
                        System.out.println("No tile in this position");
                    }
                    else{
                        int zzzs = playerController.catchZZZs(1);
                        selectedTile2.placeZzzs(zzzs, false);
                    } 
                }
            }
        } else {
            boolean onlyOneTile = userInput.getCatchZzzsDecision();
            int tileIndex = userInput.getCatchTileIndex();
            TileController selectedTile = gameBoardController.getTile(tileIndex);
            int zzzs = playerController.catchZZZs(onlyOneTile ? 2 : 1);
            selectedTile.placeZzzs(zzzs, false);
            if (!onlyOneTile) {
                int tileIndex2 = userInput.getCatchTileIndex();
                TileController selectedTile2 = gameBoardController.getTile(tileIndex2);
                zzzs = playerController.catchZZZs(1);
                selectedTile2.placeZzzs(zzzs, false);
            }
        }
        TileController topTile = tileDeck.getTopTile();
        gameBoardController.placeTopTile(topTile);
    }
}