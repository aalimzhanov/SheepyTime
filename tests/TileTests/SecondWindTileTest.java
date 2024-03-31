package tests.TileTests;

import models.GameBoard;
import models.Player;
import models.cards.MoveSpacesCard;
import models.tiles.SecondWindTile;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SecondWindTileTest {

    private Player player;
    private SecondWindTile secondWindTile;
    private GameBoard board; 
    private UserInput userInput; 

    @Before
    public void setUp() {
        secondWindTile = new SecondWindTile();
        player = new Player("tolga", "blue");
        
        player.gainCard(new MoveSpacesCard(3)); 
        player.gainCard(new MoveSpacesCard(5)); 
        
        board = new GameBoard();
        userInput = new UserInput(); 
    }

    @Test
    public void testActivateEffectDiscardsHand() {
        assertTrue("Player should initially need a card", player.needsACard()); 
        secondWindTile.activateEffect(player, board, userInput);
        assertTrue("Player's hand should be empty after activating Second Wind Tile", player.needsACard());
    }

    @Test
    public void testActivateEffectMakesScaredPlayerBrave() {
        player.becomeScared();
        assertTrue("Player should be scared before activating the tile", player.isScared());
        secondWindTile.activateEffect(player, board, userInput);
        assertFalse("Player should become brave after activating Second Wind Tile", player.isScared());
    }

    @Test
    public void testZZZsDecrementForPlayerWithoutInfiniteZZZs() {
        int initialZZZs = player.getNumOfZzzs();
        secondWindTile.activateEffect(player, board, userInput);
        assertEquals("Player's ZZZs should decrement by 1 after activating the tile", initialZZZs - 1, player.getNumOfZzzs());
    }

   
}
