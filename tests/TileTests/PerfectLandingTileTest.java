package tests.TileTests;

import models.GameBoard;
import models.Player;
import models.tiles.PerfectLandingTile;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PerfectLandingTileTest {

    private Player playerCrossedFenceWithZZZs;
    private Player playerNotCrossedFence;
    private PerfectLandingTile perfectLandingTile;
    private GameBoard board; 
    private UserInput userInput; 

    @Before
    public void setUp() {
        perfectLandingTile = new PerfectLandingTile();
        userInput = new UserInput(); 
        
        playerCrossedFenceWithZZZs = new Player("player crossed fence with ZZZs", "red");
        playerCrossedFenceWithZZZs.crossFence(); 
        playerCrossedFenceWithZZZs.catchZZZs(5); 

        playerNotCrossedFence = new Player("PlayerNotCrossedFence", "Color");
        
        board = new GameBoard() {
        };
    }

    @Test
    public void testActivateEffectGainsWinksForCrossedFence() {
        int initialWinks = playerCrossedFenceWithZZZs.getWinks();
        perfectLandingTile.activateEffect(playerCrossedFenceWithZZZs, board, userInput);
        assertEquals("Player should gain winks equal to the space number", initialWinks + 10, playerCrossedFenceWithZZZs.getWinks());
    }

    @Test
    public void testActivateEffectDoesNotGainWinksForNotCrossedFence() {
        int initialWinks = playerNotCrossedFence.getWinks();
        perfectLandingTile.activateEffect(playerNotCrossedFence, board, userInput);
        assertEquals("Player should not gain winks if they haven't crossed the fence", initialWinks, playerNotCrossedFence.getWinks());
    }

    @Test
    public void testActivateEffectDecrementsZZZsWhenApplicable() {
        int initialZZZs = playerCrossedFenceWithZZZs.getNumOfZzzs();
        perfectLandingTile.activateEffect(playerCrossedFenceWithZZZs, board, userInput);
        assertEquals("ZZZs should be decreased by 1", initialZZZs - 1, playerCrossedFenceWithZZZs.getNumOfZzzs());
    }
    
}
