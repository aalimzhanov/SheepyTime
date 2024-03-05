package controllers;

import models.GameBoard;
import models.Movable;
import models.Nightmare;
import models.Tile;
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

    public void updateView() {
        gameBoardView.updateView(gameBoard);
    }

    public void placeTile(int position, Tile tile) {
        try {
            gameBoard.placeTile(position, tile);
            updateView();
        } catch (IllegalArgumentException e) {
            gameBoardView.showError(e.getMessage());
        }
    }

    public void addMovableToBoard(Movable movable) {
        gameBoard.placeMovable(movable, 1);
        updateView();
    }

    // In case we need to put the movable to a certain location
    public void placeMovable(Movable movable, int position) {
        gameBoard.placeMovable(movable, position);
        updateView();
    }

    public void moveMovable(Movable movable, int amount) {
        gameBoard.moveMovable(movable, amount);
        updateView();
    }

    public void callItANight(Movable movable) {
        gameBoard.callItANight(movable);
        updateView();
    }

    public boolean moveNightmare(int amount) {
        boolean crossedFence = gameBoard.moveNightmare(amount);
        if (crossedFence) {
            gameBoard.wakeEveryone();
        }
        updateView();
        return crossedFence;
    }

    public boolean jumpNightmare(int amount) {
        boolean crossedFence = gameBoard.jumpNightmare(amount);
        if (crossedFence) {
            gameBoard.wakeEveryone();
        }
        updateView();
        return crossedFence;
    }

    public void addNightmareToBoard(Nightmare nightmare) {
        gameBoard.addNightmareToBoard(nightmare);
        updateView();
    }

    public void resetPositions() {
        gameBoard.resetPositions();
        updateView();
    }

    public boolean isTilePlaced(int position) {
        return gameBoard.isTilePlaced(position);
    }

    public Tile getTile(int position) {
        return gameBoard.getTile(position);
    }

    public int getMovablePosition(Movable movable) {
        return gameBoard.getMovablePosition(movable);
    }

    public int getNumOfDreamTiles() {
        return gameBoard.getNumOfDreamTiles();
    }

    public void placeTopTile(Tile tile) {
        gameBoard.placeTopTile(tile);
    }
    public boolean isTurnOver(){
        return gameBoard.isTurnOver();
    }

}
