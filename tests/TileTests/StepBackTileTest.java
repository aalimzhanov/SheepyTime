package tests.TileTests;


import models.GameBoard;
import models.Player;
import models.tiles.StepBackTile;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StepBackTileTest {

    private Player scaredPlayerWithZZZs;
    private Player bravePlayerWithZZZs;
    private StepBackTile stepBackTile;
    private GameBoard board; 
    private UserInput userInput; 

    @Before
    public void setUp() {
        stepBackTile = new StepBackTile();
        
        scaredPlayerWithZZZs = new Player("scared player with ZZZs", "blue");
        scaredPlayerWithZZZs.catchZZZs(5); 
        scaredPlayerWithZZZs.becomeScared(); 
        
        bravePlayerWithZZZs = new Player("brave player with ZZZs", "red");
        bravePlayerWithZZZs.catchZZZs(5); 
        board = new GameBoard();
    }

    @Test
    public void testActivateEffectMovesPlayerBackwardAndMakesScaredPlayerBrave() {
        int initialPosition = board.getMovablePosition(scaredPlayerWithZZZs);
        stepBackTile.activateEffect(scaredPlayerWithZZZs, board, userInput);
        assertEquals("Player should move backward by 1 space", initialPosition - 1, board.getMovablePosition(scaredPlayerWithZZZs));
        assertFalse("Scared player should become brave", scaredPlayerWithZZZs.isScared());
    }

    @Test
    public void testActivateEffectMovesBravePlayerBackward() {
        int initialPosition = board.getMovablePosition(bravePlayerWithZZZs);
        stepBackTile.activateEffect(bravePlayerWithZZZs, board, userInput);
        assertEquals("Brave player should move backward by 1 space", initialPosition - 1, board.getMovablePosition(bravePlayerWithZZZs));
    }

    @Test
    public void testZZZsDecrementForPlayersWithFiniteZZZs() {
        int initialZZZs = scaredPlayerWithZZZs.getNumOfZzzs();
        stepBackTile.activateEffect(scaredPlayerWithZZZs, board, userInput);
        assertEquals("Player's ZZZs should decrease by 1", initialZZZs - 1, scaredPlayerWithZZZs.getNumOfZzzs());
    }
    
}
