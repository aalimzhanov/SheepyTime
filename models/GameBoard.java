package models;

import java.util.HashMap;
import java.util.Map;

import controllers.TileController;

/**
 * Represents the game board for the SheepyTime game.
 * This class manages the placement and movement of tiles, movables, and the nightmare.
 * It also provides various methods to interact with the game board.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class GameBoard {
    private Map<Movable, Integer> gameBoard;
    private Nightmare nightmare;
    private int nightmarePos;
    private TileController[] tiles;
    private final int WAKE_UP_POSITION = -1; // not on the board
    private final int NIGHTMARE_DEFAULT_POSITION = 0; // center of the board
    private final int CALL_IT_A_NIGHT_POSITION = 11; // off the board

    public GameBoard() {
        gameBoard = new HashMap<>();
        tiles = new TileController[10];
    }

    // Tile methods
    /**
     * Places a tile at the specified position on the game board.
     *
     * @param position The position where the tile should be placed. Must be between 1 and 10 (inclusive).
     * @param tile The tile to be placed on the game board.
     * @throws IllegalArgumentException if the position is invalid or already occupied by a tile.
     */
    public void placeTile(int position, TileController tile) {

        if (position < 1 || position > 10) {
            throw new IllegalArgumentException("Invalid position");
        }
        position -= 1; // Adjust for 0-based indexing
        if (tiles[position] != null) {
            throw new IllegalArgumentException("This position is already occupied by a tile.");
        }
        tiles[position] = tile;
    }

    /**
     * Checks if a tile is placed at the specified position on the game board.
     *
     * @param position the position of the tile to check
     * @return true if a tile is placed at the specified position, false otherwise
     */
    public boolean isTilePlaced(int position) {
        return tiles[position - 1] != null;
    }

    /**
     * Represents a controller for a tile in the game board.
     */
    public TileController getTile(int position) {
        return tiles[position - 1];
    }

    /**
     * Returns the number of dream tiles on the game board.
     *
     * @return the number of dream tiles
     */
    public int getNumOfDreamTiles() {
        int count = 0;
        for (TileController tile : tiles) {
            if (tile != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Places the top tile of the deck on the first available slot.
     * If there are no empty slots, the tile is not placed.
     *
     * @param tile the tile to be placed on the top of the game board
     */
    public void placeTopTile(TileController tile) {
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i] == null) {
                tiles[i] = tile;
                return;
            }
        }
    }

    // Movable methods
    /**
     * Places a movable object on the game board at the specified position.
     *
     * @param movable The movable object to be placed on the game board.
     * @param position The position on the game board where the movable object should be placed.
     */
    public void placeMovable(Movable movable, int position) {
        gameBoard.put(movable, position);
    }

    /**
     * Returns a map of movables and their corresponding positions.
     *
     * @return a map of movables and their corresponding positions
     */
    public Map<Movable, Integer> getMovables() {
        return gameBoard;
    }

    /**
     * Moves the specified Movable object on the game board by the given amount.
     * 
     * @param movable The Movable object to be moved.
     * @param amount The amount by which the Movable object should be moved.
     * @throws IllegalArgumentException if the Movable object is not on the board,
     *         or if the Movable object has called it a night,
     *         or if the Movable object has woken up.
     */
    public void moveMovable(Movable movable, int amount) {
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
        boolean crossedFence = false;
        if (newPosition > 10) {
            newPosition %= 10; // Wrap around
            crossedFence = true;
        } else if (newPosition <= 0) {
            newPosition = 1; // Can't cross the fence backwards
        }

        if (newPosition == nightmarePos) {
            if (movable.isScared()) {
                wakeUpMovable(movable);
                return;
            }
            movable.becomeScared();
        }

        gameBoard.put(movable, newPosition);
        if (crossedFence) {
            movable.crossFence();
        }
    }

    /**
     * Scare all movables at the specified position.
     * If a movable is already scared, it will be woken up.
     * If a movable is not scared, it will become scared.
     *
     * @param pos the position to scare the movables at
     */
    public void scareMovablesAtPosition(int pos) {
        gameBoard.forEach((movable, movablePos) -> {
            if (movablePos == pos) {
                if(movable.isScared()){
                    wakeUpMovable(movable);
                }else{    
                    movable.becomeScared();
                }
            }
        });
    }

    /**
     * Wakes up the specified movable on the game board.
     * If the movable is present on the game board, it is moved to the wake up position
     * and its `wakeUp` method is called.
     *
     * @param movable the movable to wake up
     */
    public void wakeUpMovable(Movable movable) {
        if (gameBoard.containsKey(movable)) {
            gameBoard.put(movable, WAKE_UP_POSITION);
            movable.wakeUp();
        }
    }

    /**
     * Checks if the specified movable object is awake on the game board.
     *
     * @param movable the movable object to check
     * @return true if the movable object is awake, false otherwise
     */
    public boolean isAwake(Movable movable) {
        return gameBoard.get(movable) == WAKE_UP_POSITION;
    }

    /**
     * Wakes up all the movable objects on the game board and sets their positions to the wake-up position.
     */
    public void wakeEveryone() {
        gameBoard.forEach((movable, pos) -> {
            wakeUpMovable(movable);
        });
    }

    /**
     * Moves the specified movable object to the "call it a night" position on the game board.
     *
     * @param movable the movable object to be moved
     */
    public void callItANight(Movable movable) {
        if (gameBoard.containsKey(movable)) {
            gameBoard.put(movable, CALL_IT_A_NIGHT_POSITION);
        }
    }

    /**
     * Returns the position of the specified movable on the game board.
     *
     * @param movable the movable object whose position is to be retrieved
     * @return the position of the movable on the game board
     */
    public int getMovablePosition(Movable movable) {
        return gameBoard.get(movable);
    }

    /**
     * Checks if the turn is over by verifying if all movables have either woken up or called it a night.
     *
     * @return true if the turn is over, false otherwise.
     */
    public boolean isTurnOver() {
        for (int position : gameBoard.values()) {
            if (position != CALL_IT_A_NIGHT_POSITION && position != WAKE_UP_POSITION) {
                return false;
            }
        }
        return true;
    }

    // Nightmare methods
    /**
     * Adds a nightmare to the game board.
     * 
     * @param nightmare the nightmare to be added
     */
    public void addNightmareToBoard(Nightmare nightmare) {
        this.nightmare = nightmare;
        nightmarePos = NIGHTMARE_DEFAULT_POSITION;
    }

    /**
     * Moves the nightmare on the game board by the specified amount.
     * The nightmare moves one space at a time, scaring any player it lands on.
     * 
     * @param amount the number of spaces to move the nightmare
     * @return true if the nightmare reaches the end of the board and wraps around to the beginning, false otherwise
     */
    public boolean moveNightmare(int amount) {
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

    /**
     * Moves the nightmare position by the specified amount and scares any movables at the new position.
     * If the new position exceeds 10, the nightmare position is reset to the default position and true is returned.
     * Otherwise, false is returned.
     *
     * @param amount the amount to move the nightmare position by
     * @return true if the new position exceeds 10 and the nightmare position is reset, false otherwise
     */
    public boolean jumpNightmare(int amount) {
        nightmarePos += amount;
        if (nightmarePos > 10) {
            nightmarePos = NIGHTMARE_DEFAULT_POSITION;
            return true;
        }
        scareMovablesAtPosition(nightmarePos);
        return false;
    }

    /**
     * Returns the position of the nightmare on the game board.
     *
     * @return the position of the nightmare
     */
    public int getNightmarePos() {
        return nightmarePos;
    }

    /**
     * Returns the Nightmare.
     *
     * @return the Nightmare object
     */
    public Nightmare getNightmare() {
        return nightmare;
    }

    // Other methods
    /**
     * Resets the positions of all the movable objects on the game board.
     * This method sets the position of each movable object to 1 and makes them become brave.
     * It also resets the position of the nightmare object to the default position.
     */
    public void resetPositions() {
        gameBoard.forEach((movable, pos) -> {
            gameBoard.put(movable, 1);
            movable.becomeBrave();
        });
        nightmarePos = NIGHTMARE_DEFAULT_POSITION;
    }

    /**
     * Checks if the player has zzzs on any other dream tiles within 2 spaces of this one.
     * 
     * @param tile the tile to check for adjacent Zzzs
     * @return true if the tile has adjacent Zzzs, false otherwise
     */
    public boolean hasAdjacentZzzs(Tile tile){
        for (int i = 0; i < 10; i++){
            if(tiles[i]!= null ){
                if(tiles[i].getModel().equals(tile)){
                    if (i > 0 && tiles[i-1].hasZzzs()) {
                        return true;
                    }
                    if (i < 9 && tiles[i+1].hasZzzs()) {
                        return true;
                    }
                    if (i > 1 && tiles[i-2].hasZzzs()){
                        return true;
                    }
                    if (i < 8 && tiles[i+2].hasZzzs()) {
                        return true;
                    }

                }
            }
        }
        return false;
    }
    /**
     * Returns an array of TileController objects representing the tiles on the game board.
     *
     * @return an array of TileController objects representing the tiles on the game board
     */
    public TileController[] getTiles(){
        return tiles;
    }
}
