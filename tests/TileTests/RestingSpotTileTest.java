package tests.TileTests;


import models.GameBoard;
import models.Player;
import models.tiles.RestingSpotTile;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestingSpotTileTest {

    private Player scaredPlayerWithZZZs;
    private Player bravePlayerWithZZZs;
    private Player playerWithoutZZZs; 
    private RestingSpotTile restingSpotTile;
    private GameBoard board; 
    private UserInput userInput; 

    @Before
    public void setUp() {
        restingSpotTile = new RestingSpotTile();
        
        scaredPlayerWithZZZs = new Player("scared player with ZZZs", "red");
        scaredPlayerWithZZZs.catchZZZs(5); 
        scaredPlayerWithZZZs.becomeScared(); 
        
        bravePlayerWithZZZs = new Player("brave player with ZZZs", "blue");
        bravePlayerWithZZZs.catchZZZs(5); 
        
        playerWithoutZZZs = new Player("player without ZZZs", "green");
        
        board = new GameBoard(); 
        userInput = new UserInput(); 
    }

    @Test
    public void testActivateEffectCatchesZZZAndBecomesBraveForScaredPlayer() {
        int initialZZZs = scaredPlayerWithZZZs.getNumOfZzzs();
        restingSpotTile.activateEffect(scaredPlayerWithZZZs, board, userInput);
        assertEquals("Scared player should catch 1 ZZZ", initialZZZs + 1, scaredPlayerWithZZZs.getNumOfZzzs());
        assertFalse("Scared player should become brave", scaredPlayerWithZZZs.isScared());
    }

    @Test
    public void testActivateEffectCatchesZZZForBravePlayer() {
        int initialZZZs = bravePlayerWithZZZs.getNumOfZzzs();
        restingSpotTile.activateEffect(bravePlayerWithZZZs, board, userInput);
        assertEquals("Brave player should catch 1 ZZZ", initialZZZs + 1, bravePlayerWithZZZs.getNumOfZzzs());
    }

    @Test
    public void testActivateEffectDoesNotApplyForPlayerWithoutZZZs() {
        int initialZZZs = playerWithoutZZZs.getNumOfZzzs();
        restingSpotTile.activateEffect(playerWithoutZZZs, board, userInput);
        assertEquals("Player without ZZZs should not catch ZZZs", initialZZZs, playerWithoutZZZs.getNumOfZzzs());
    }

}
