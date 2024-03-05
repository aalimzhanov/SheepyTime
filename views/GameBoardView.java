package views;

import models.GameBoard;
import models.Tile;

public class GameBoardView {

    public void updateView(GameBoard gameBoard) {
        System.out.println("Current Game Board State:");
        displayTiles(gameBoard);
        displayMovables(gameBoard);
        displayNightmarePosition(gameBoard);
    }

    private void displayTiles(GameBoard gameBoard) {
        Tile[] tiles = gameBoard.getTiles();
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i] != null) {
                System.out.println("Tile at position " + (i + 1) + ": " + tiles[i].getName());
            }
        }
    }

    private void displayMovables(GameBoard gameBoard) {
        gameBoard.getMovables().forEach((movable, position) -> {
            System.out.println("Player " + movable.getName() + " is at position: " + position);
        });
    }

    private void displayNightmarePosition(GameBoard gameBoard) {
        System.out.println(gameBoard.getNightmare().getName() + " is at position: " + gameBoard.getNightmarePos());
    }

    public void showError(String message) {
        System.err.println("Error: " + message);
    }

}
