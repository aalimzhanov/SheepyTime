package models;

import java.util.HashMap;
import java.util.Map;

import controllers.TileController;

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

    public boolean isTilePlaced(int position) {
        return tiles[position - 1] != null;
    }

    public TileController getTile(int position) {
        return tiles[position - 1];
    }

    public int getNumOfDreamTiles() {
        int count = 0;
        for (TileController tile : tiles) {
            if (tile != null) {
                count++;
            }
        }
        return count;
    }

    public void placeTopTile(TileController tile) {
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i] == null) {
                tiles[i] = tile;
                return;
            }
        }
    }

    // Movable methods
    public void placeMovable(Movable movable, int position) {
        gameBoard.put(movable, position);
    }

    public Map<Movable, Integer> getMovables() {
        return gameBoard;
    }

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

    public void scareMovablesAtPosition(int pos) {
        gameBoard.forEach((movable, movablePos) -> {
            if (movablePos == pos) {
                if(movable.isScared()){
                    gameBoard.put(movable, WAKE_UP_POSITION);
                }else{    
                    movable.becomeScared();
                }
            }
        });
    }

    public void wakeUpMovable(Movable movable) {
        if (gameBoard.containsKey(movable)) {
            gameBoard.put(movable, WAKE_UP_POSITION);
            movable.wakeUp();
        }
    }

    public boolean isAwake(Movable movable) {
        return gameBoard.get(movable) == WAKE_UP_POSITION;
    }

    public void wakeEveryone() {
        gameBoard.forEach((movable, pos) -> {
            gameBoard.put(movable, WAKE_UP_POSITION);
        });
    }

    public void callItANight(Movable movable) {
        if (gameBoard.containsKey(movable)) {
            gameBoard.put(movable, CALL_IT_A_NIGHT_POSITION);
        }
    }

    public int getMovablePosition(Movable movable) {
        return gameBoard.get(movable);
    }

    public boolean isTurnOver() {
        for (int position : gameBoard.values()) {
            if (position != CALL_IT_A_NIGHT_POSITION && position != WAKE_UP_POSITION) {
                return false;
            }
        }
        return true;
    }

    // Nightmare methods
    public void addNightmareToBoard(Nightmare nightmare) {
        this.nightmare = nightmare;
        nightmarePos = NIGHTMARE_DEFAULT_POSITION;
    }

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

    public boolean jumpNightmare(int amount) {
        nightmarePos += amount;
        if (nightmarePos > 10) {
            nightmarePos = NIGHTMARE_DEFAULT_POSITION;
            return true;
        }
        scareMovablesAtPosition(nightmarePos);
        return false;
    }

    public int getNightmarePos() {
        return nightmarePos;
    }

    public Nightmare getNightmare() {
        return nightmare;
    }

    // Other methods
    public void resetPositions() {
        gameBoard.forEach((movable, pos) -> {
            gameBoard.put(movable, 1);
            movable.becomeBrave();
        });
        nightmarePos = NIGHTMARE_DEFAULT_POSITION;
    }

    // Return true if player has zzzs on any other dream tiles within 2 spaces of this one
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
    public TileController[] getTiles(){
        return tiles;
    }
}
