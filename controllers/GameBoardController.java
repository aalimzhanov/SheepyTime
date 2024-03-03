package controllers;

import java.util.List;

import models.GameBoard;
import models.Movable;
import models.Nightmare;
import tiles.Tile;
import views.GameBoardView;

public class GameBoardController {

    private GameBoard gameBoard;
    private GameBoardView gameBoardView;

    public GameBoardController(GameBoard gameBoard, GameBoardView gameBoardView){
        this.gameBoard = gameBoard;
        this.gameBoardView = gameBoardView;
    }
    public void setupBoard(List<Movable> players, Nightmare nightmare){
        for (Movable movable : players) {
            addMovableToBoard(movable);
        }
        addNightmareToBoard(nightmare);
        updateView();
    }
    
    public GameBoard getModel(){
        return gameBoard;
    }

    public void updateView(){
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

    public boolean moveMovable(Movable movable, int amount) {
        boolean crossedFence = gameBoard.moveMovable(movable, amount);
        updateView();
        return crossedFence; 
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

}
