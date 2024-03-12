package tests.TileTests;


import models.GameBoard;
import models.Player;
import models.tiles.IntenseDreamsTile;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntenseDreamsTileTest {

    private Player playerWithZZZs;
    private Player playerWithInfiniteZZZs;
    private Player playerWith0ZZZs;
    private IntenseDreamsTile intenseDreamsTile;
    private GameBoard board; 
    private UserInput userInput; 

    @Before
    public void setUp() {
        intenseDreamsTile = new IntenseDreamsTile();
        
        playerWithZZZs = new Player("player with ZZZs", "green");
        playerWithZZZs.catchZZZs(5); 
        
        playerWithInfiniteZZZs = new Player("player with infinite ZZZs", "blue");
        
        playerWith0ZZZs = new Player("player with 0 ZZZs", "red");
        
        board = new GameBoard(); 
        userInput = new UserInput(); 
    }

    @Test
    public void testActivateEffectMakesPlayerScaredAndGainsWinks() {
        intenseDreamsTile.activateEffect(playerWithZZZs, board, userInput);
        assertTrue("Player should become scared", playerWithZZZs.isScared());
        assertEquals("Player should gain 4 winks", 4, playerWithZZZs.getWinks());
    }

    @Test
    public void testActivateEffectDecrementsZZZsForPlayerWithFiniteZZZs() {
        int initialZZZs = playerWithZZZs.getNumOfZzzs();
        intenseDreamsTile.activateEffect(playerWithZZZs, board, userInput);
        assertEquals("ZZZs should be descreased by 1", initialZZZs - 1, playerWithZZZs.getNumOfZzzs());
    }

    @Test
    public void testActivateEffectDoesNotDecrementZZZsForPlayerWithInfiniteZZZs() {
        intenseDreamsTile.activateEffect(playerWithInfiniteZZZs, board, userInput);
        assertEquals("ZZZs should not be decreased for player with infinite ZZZs", 0, playerWithInfiniteZZZs.getNumOfZzzs());
    }

    @Test
    public void testActivateEffectDoesNotApplyWith0ZZZs() {
        intenseDreamsTile.activateEffect(playerWith0ZZZs, board, userInput);
        assertFalse("Player should not become scared with 0 ZZZs", playerWith0ZZZs.isScared());
        assertEquals("Player should not gain winks with 0 ZZZs", 0, playerWith0ZZZs.getWinks());
    }
}
