package TileTests;

import models.GameBoard;
import models.Player;
import models.Tile;
import models.tiles.LoneSheepTile;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoneSheepTileTest {

    private Player playerWithZZZs;
    private LoneSheepTile loneSheepTile;
    private GameBoard boardWithAdjacentZzzs;
    private GameBoard boardWithoutAdjacentZzzs;
    private UserInput userInput; 

    @Before
    public void setUp() {
        loneSheepTile = new LoneSheepTile();
        playerWithZZZs = new Player("tolga", "Blue");
        playerWithZZZs.catchZZZs(5); 
        
        userInput = new UserInput(); 
        
        boardWithAdjacentZzzs = new GameBoard() {
            @Override
            public boolean hasAdjacentZzzs(Tile tile) {
                return true; 
            }
        };

        boardWithoutAdjacentZzzs = new GameBoard() {
            @Override
            public boolean hasAdjacentZzzs(Tile tile) {
                return false; 
            }
        };
    }

    @Test
    public void testActivateEffectGainsWinksWithoutAdjacentZzzs() {
        int initialWinks = playerWithZZZs.getWinks();
        loneSheepTile.activateEffect(playerWithZZZs, boardWithoutAdjacentZzzs, userInput);
        assertEquals("Player should gain 3 winks without adjacent ZZZs", initialWinks + 3, playerWithZZZs.getWinks());
    }

    @Test
    public void testActivateEffectNoWinksGainWithAdjacentZzzs() {
        int initialWinks = playerWithZZZs.getWinks();
        loneSheepTile.activateEffect(playerWithZZZs, boardWithAdjacentZzzs, userInput);
        assertEquals("Player should not gain winks with adjacent ZZZs", initialWinks, playerWithZZZs.getWinks());
    }

    
}
