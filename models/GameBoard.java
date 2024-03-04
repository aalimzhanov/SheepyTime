package models;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    private Map<Movable, Integer> gameBoard;
    private Nightmare nightmare;
    private int nightmarePos;
    private Tile[] tiles;
    private final int WAKE_UP_POSITION = -1;    // not on the board
    private final int NIGHTMARE_DEFAULT_POSITION = 0;    // center of the board
    private final int CALL_IT_A_NIGHT_POSITION = 11;    // off the board
    public GameBoard(){
        gameBoard = new HashMap<>();
        tiles = new Tile[10];
        
    }
    public void placeTile(int position, Tile tile) {
        position -= 1; // Adjust for 0-based indexing
        
        if(position < 1 || position > 10){
            throw new IllegalArgumentException("Invalid position");
        }
        if(tiles[position] != null){
            throw new IllegalArgumentException("This position is already occupied by a tile.");
        }
        tiles[position] = tile;
    }
    public void placeMovable(Movable movable, int position) {
        gameBoard.put(movable, position);
    }
    public void addNightmareToBoard(Nightmare nightmare){
        this.nightmare = nightmare;
        nightmarePos = NIGHTMARE_DEFAULT_POSITION;
    }

    // Returns true if the fence is crossed
    public boolean moveNightmare(int amount) {
        // the nightmare moves one space at a time, scaring any player it lands on
        for (int i = 0; i < amount; i++) {
            nightmarePos++;
            scareMovablesAtPosition(nightmarePos);
            if (nightmarePos > 10) {
                nightmarePos = NIGHTMARE_DEFAULT_POSITION;
                return true;
            }
        }
        return false;
    }
    // Nightmare jumps by the amount specified, and scares any player it lands on    
    public boolean jumpNightmare(int amount){
        nightmarePos += amount;
        if(nightmarePos > 10){
            nightmarePos = NIGHTMARE_DEFAULT_POSITION;
            return true;
        }
        scareMovablesAtPosition(nightmarePos);
        return false;
    }
    public int getNightmarePos(){
        return nightmarePos;
    }
    public Nightmare getNightmare(){
        return nightmare;
    }
    public Tile[] getTiles(){
        return tiles;
    }
    public Map<Movable, Integer> getMovables(){
        return gameBoard;
    }
    // Returns true if the movable crossed the fence
    public boolean moveMovable(Movable movable, int amount) {
        if (!gameBoard.containsKey(movable)) {
            throw new IllegalArgumentException("This element is not on the board");
        }
        if (gameBoard.get(movable) == CALL_IT_A_NIGHT_POSITION) {
            throw new IllegalArgumentException("This element called it a night");
        }
        if (gameBoard.get(movable) == WAKE_UP_POSITION) {
            throw new IllegalArgumentException("This element is awake");
        }
    
        int currentPosition = gameBoard.get(movable);
        int newPosition = currentPosition + amount;
        
        // Adjust newPosition for circular board logic
        if (newPosition > 10) {
            newPosition %= 10; // Wrap around
        } else if (newPosition <= 0) {
            newPosition = 1; // Can't cross the fence backwards
        }
        
        boolean crossedTheFence = amount > 0 && newPosition <= amount;
        if(!crossedTheFence && newPosition == nightmarePos){
            movable.becomeScared();
        }
        gameBoard.put(movable, newPosition);
    
        return crossedTheFence;
    }

    // Needed for some nightmare cards
    public void scareMovablesAtPosition(int pos) {
        gameBoard.forEach((movable, movablePos) -> {
            if (movablePos == pos) {
                movable.becomeScared();
            }
        });
    }
    public void wakeUpMovable(Movable movable){
        if(gameBoard.containsKey(movable)){
            gameBoard.put(movable, WAKE_UP_POSITION);
        }
    }
    public boolean isAwake(Movable movable){
        return gameBoard.get(movable) == WAKE_UP_POSITION;
    }
    public void wakeEveryone(){
        gameBoard.forEach((movable, pos) -> {
            gameBoard.put(movable, WAKE_UP_POSITION);
        });
    }
    public void callItANight(Movable movable){
        if(gameBoard.containsKey(movable)){
            gameBoard.put(movable, CALL_IT_A_NIGHT_POSITION);
        }
    }
    public void resetPositions(){
        gameBoard.forEach((movable, pos) -> {
            gameBoard.put(movable, 1);
        });
        nightmarePos = NIGHTMARE_DEFAULT_POSITION;
    }
    public boolean isTilePlaced(int position){
        return tiles[position - 1] != null;
    }
    public Tile getTile(int position){
        return tiles[position - 1];
    }
    public int getMovablePosition(Movable movable){
        return gameBoard.get(movable);
    }
    public int getNumOfDreamTiles(){
        int count = 0;
        for(Tile tile : tiles){
            if(tile != null){
                count++;
            }
        }
        return count;
    }
    public void placeTopTile(Tile tile){
        for(int i = 0; i < tiles.length; i++){
            if(tiles[i] == null){
                tiles[i] = tile;
                return;
            }
        }
    }
}
