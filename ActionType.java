/**
 * Enumerates the types of actions that can be performed in the game.
 * 
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 * @version 
 */
public enum ActionType {
    /**
     * Represents an action to move a game element to a different position.
     */
    MOVE,

    /**
     * Represents an action to make a game element jump, skipping all the square along the way.
     */
    JUMP,

    /**
     * Represents an action to catch ZZZTokens onto a dream tile.
     */
    CATCH,

    /**
     * Represents an action to place a dream tile on the game board.
     */
    PLACE_TILE,

    /**
     * Represents an action to conclude the current round for the player.
     */
    CALL_IT_A_NIGHT
}

