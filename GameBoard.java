import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private List<List<Movable>> gameBoard;
    private List<Tile> activeTiles;
    private GamePhase gamePhase;
    
    public GameBoard(){
        gameBoard = new ArrayList<>();
        populateGameBoard();
        activeTiles = new ArrayList<>();
        populateTiles();
    }
    private void populateGameBoard(){
        for (int i = 0; i < 10; i++){
            List<Movable> tempList = new ArrayList<>();
            gameBoard.add(tempList);
        }
    }
    private void populateTiles(){
        for (int i = 0; i < 10; i++){
            activeTiles.add(null);
        }
    }

    public boolean moveObject(Movable movingObj, int movingValue){
        Movable objFound = null;
        int objIndex = -1;

        for (int i = 0; i < gameBoard.size() ; i++){
            List<Movable> square = gameBoard.get(i);
            for (int j = 0; j < square.size(); j++){
                if (movingObj.equals(square.get(j))){
                    objFound = square.get(j);
                    objIndex = i;
                    square.remove(j);
                }
            }
        }
        if(objFound != null){
            int newIndex = objIndex + movingValue;
            boolean crossedTheFence = false;
            if (newIndex >= 10){
                crossedTheFence = true;
                newIndex %= 10;
            }
            gameBoard.get(newIndex).add(movingObj);
            return crossedTheFence;
        }else{
            throw new IllegalArgumentException("This element is not on the board");
        }
    }

    public void placeTile(Tile newTile, int index){
        if(activeTiles.get(index)==null){
            activeTiles.set(index, newTile);
        }
        else{
            throw new IllegalStateException("This index is already occupied with a Tile");
        }
    }

    public boolean endOfRound(){
        boolean isEndOfRound = true;
        for (int i = 0; i < gameBoard.size() ; i++){
            List<Movable> square = gameBoard.get(i);
            for (int j = 0; j < square.size(); j++){
                if (square.get(j) instanceof Sheep){
                    isEndOfRound = false;
                    break;
                }
            }
        }
        return isEndOfRound;
    }

    public void changePhase(){
        if(gamePhase == GamePhase.RESTING_PHASE){
            gamePhase = GamePhase.RACING_PHASE;
        }
        else{
            gamePhase = GamePhase.RESTING_PHASE;
        }
    }
}
