package models;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    private Map<Movable, Integer> gameBoard;
    
    public GameBoard(){
        gameBoard = new HashMap<>();
    }


    public void moveMovable(Movable movable, int amount) throws IllegalArgumentException{
        if(gameBoard.containsKey(movable)){
            
            int objIndex = gameBoard.get(movable);
            int newIndex = objIndex + amount;
            boolean crossedTheFence = false;
            if (newIndex > 10){
                crossedTheFence = true;
                newIndex %= 10;
            }
            gameBoard.put(movable, newIndex);
            movable.move(newIndex);
            if(crossedTheFence){
                // scoreboard.gainWinks(movable); Fix the logic in scoreboard
                movable.crossTheFence();    //Handle the cross the fence logic
            }
        }else{
            throw new IllegalArgumentException("This element is not on the board");
        }
    }
}
