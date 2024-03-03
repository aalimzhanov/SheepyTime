package models;
import java.util.HashMap;
import java.util.Map;

import tiles.Tile;

public class GameBoard {
    private Map<Movable, Integer> gameBoard;
    private Tile[] tiles;

    public GameBoard(){
        gameBoard = new HashMap<>();
        tiles = new Tile[10];
    }
    public void placeTile(int position, Tile tile) {
        position -= 1; // Adjust for 0-based indexing
        
        if(position < 0 || position > 9){
            throw new IllegalArgumentException("Invalid position");
        }
        if(tiles[position] != null){
            throw new IllegalArgumentException("Tile already placed");
        }
        tiles[position] = tile;
    }
    public void addMovable(Movable movable, int position) {
        if(gameBoard.containsKey(movable)){
            throw new IllegalArgumentException("This element is already on the board");
        }
        // Might have to change this so that nightmare can be placed at -1, before the nightmare joins the game
        if(position < 1 || position > 10){
            throw new IllegalArgumentException("Invalid position");
        }
        gameBoard.put(movable, position);
    }


    public void moveMovable(Movable movable, int amount) throws IllegalArgumentException{
        if(gameBoard.containsKey(movable)){
            
            int currentPosition = gameBoard.get(movable);
            int newPosition = currentPosition + amount;
            boolean crossedTheFence = false;

            if (newPosition > 10){
                crossedTheFence = true;
                newPosition %= 10;
            }
            
            gameBoard.put(movable, newPosition);
            movable.move(newPosition);
            
            if(crossedTheFence){
                // scoreboard.gainWinks(movable); 
                // movable.crossTheFence();    
            }
            if (tiles[newPosition] != null) {
                // tiles[newPosition].activateEffect(movable, this);
            }
        }else{
            throw new IllegalArgumentException("This element is not on the board");
        }
    }
}
