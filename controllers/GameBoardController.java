package controllers;

import models.GameBoard;
import models.Movable;
import models.Nightmare;
import views.GameBoardView;

public class GameBoardController {

    private GameBoard gameBoard;
    private GameBoardView gameBoardView;

    public GameBoardController(GameBoard gameBoard, GameBoardView gameBoardView) {
        this.gameBoard = gameBoard;
        this.gameBoardView = gameBoardView;
    }

    public GameBoard getModel() {
        return gameBoard;
    }

    public void displayInformation() {
        gameBoardView.displayInformation(gameBoard);
    }

    public void placeTile(int position, TileController tileController) {
        try {
            gameBoard.placeTile(position, tileController);
        } catch (IllegalArgumentException e) {
            gameBoardView.showError(e.getMessage());
        }
    }

    public void addMovableToBoard(Movable movable) {
        gameBoard.placeMovable(movable, 1);
    }

    // In case we need to put the movable to a certain location
    public void placeMovable(Movable movable, int position) {
        gameBoard.placeMovable(movable, position);
    }

    public void moveMovable(Movable movable, int amount) {
        gameBoard.moveMovable(movable, amount);
    }

    public void callItANight(Movable movable) {
        gameBoard.callItANight(movable);
    }

    public boolean moveNightmare(int amount) {
        boolean crossedFence = gameBoard.moveNightmare(amount);
        if (crossedFence) {
            gameBoard.wakeEveryone();
        }
        return crossedFence;
    }

    public boolean jumpNightmare(int amount) {
        boolean crossedFence = gameBoard.jumpNightmare(amount);
        if (crossedFence) {
            gameBoard.wakeEveryone();
        }
        return crossedFence;
    }

    public void addNightmareToBoard(Nightmare nightmare) {
        gameBoard.addNightmareToBoard(nightmare);
    }

    public void resetPositions() {
        gameBoard.resetPositions();
    }

    public boolean isTilePlaced(int position) {
        return gameBoard.isTilePlaced(position);
    }

    public TileController getTile(int position) {
        return gameBoard.getTile(position);
    }

    public int getMovablePosition(Movable movable) {
        return gameBoard.getMovablePosition(movable);
    }

    public int getNumOfDreamTiles() {
        return gameBoard.getNumOfDreamTiles();
    }

    public void placeTopTile(TileController tileController) {
        gameBoard.placeTopTile(tileController);
    }
    public boolean isTurnOver(){
        return gameBoard.isTurnOver();
    }

}
