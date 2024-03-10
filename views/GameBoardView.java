package views;

import controllers.TileController;
import models.GameBoard;

public class GameBoardView {

    public void displayInformation(GameBoard gameBoard) {
        System.out.println("Current Game Board State:");
        displayTiles(gameBoard);
        displayMovables(gameBoard);
        displayNightmarePosition(gameBoard);
    }

    private void displayTiles(GameBoard gameBoard) {
        TileController[] tiles = gameBoard.getTiles();
        if(tiles.length == 0){
            System.out.println("No active Dream Tiles.");
        }
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i] != null) {
                System.out.println("Dream Tile at position " + (i + 1) + ": " + tiles[i].getTileName());
            }
        }
    }

    private void displayMovables(GameBoard gameBoard) {
        gameBoard.getMovables().forEach((movable, position) -> {
            System.out.println(movable.getName() + " is at position: " + position);
        });
    }

    private void displayNightmarePosition(GameBoard gameBoard) {
        System.out.println(gameBoard.getNightmare().getName() + " is at position: " + gameBoard.getNightmarePos());
    }

    public void showError(String message) {
        System.err.println("Error: " + message);
    }

}
