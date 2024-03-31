package views;

import controllers.TileController;
import models.GameBoard;

/**
 * This class represents the view for the game board.
 * It is responsible for displaying information about the game board state,
 * including the dream tiles, movables, and nightmare position.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class GameBoardView {

    /**
     * Displays the current game board state, including the dream tiles, movables, and nightmare position.
     *
     * @param gameBoard the game board object
     */
    public void displayInformation(GameBoard gameBoard) {
        System.out.println("Current Game Board State:");
        displayTiles(gameBoard);
        displayMovables(gameBoard);
        displayNightmarePosition(gameBoard);
    }

    /**
     * Displays the dream tiles on the game board.
     *
     * @param gameBoard the game board object
     */
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

    /**
     * Displays the movables on the game board.
     *
     * @param gameBoard the game board object
     */
    private void displayMovables(GameBoard gameBoard) {
        gameBoard.getMovables().forEach((movable, position) -> {
            System.out.println(movable.getName() + " is at position: " + position);
        });
    }

    /**
     * Displays the nightmare position on the game board.
     *
     * @param gameBoard the game board object
     */
    private void displayNightmarePosition(GameBoard gameBoard) {
        System.out.println(gameBoard.getNightmare().getName() + " is at position: " + gameBoard.getNightmarePos());
    }

    /**
     * Displays an error message.
     *
     * @param message the error message
     */
    public void showError(String message) {
        System.err.println("Error: " + message);
    }

}
