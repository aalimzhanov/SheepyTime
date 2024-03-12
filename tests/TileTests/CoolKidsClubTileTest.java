package TileTests;

import models.GameBoard;
import models.Player;
import models.tiles.CoolKidsClubTile;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoolKidsClubTileTest {

    private Player playerWithZZZs;
    private Player playerWithoutInfiniteZZZs;
    private Player playerWith0ZZZs;
    private CoolKidsClubTile coolKidsClubTile;
    private GameBoard board; 
    private UserInput userInput; 

    @Before
    public void setUp() {
        CoolKidsClubTile CoolKidsClubTile = new CoolKidsClubTile();

        // Setup players for various scenarios
        playerWithZZZs = new Player("player with ZZZs", "blue");
        playerWithZZZs.catchZZZs(5);

        playerWithoutInfiniteZZZs = new Player("player without infinite ZZZs", "red");
        playerWithoutInfiniteZZZs.catchZZZs(5); 

        playerWith0ZZZs = new Player("player with 0 ZZZs", "green");
       
        board = new GameBoard(); 
        userInput = new UserInput(); 
    }

    @Test
    public void testActivateEffectMovesPillowDownForPlayerWithZZZs() {
        int initialPillowPosition = playerWithZZZs.getPillowPosition();
        coolKidsClubTile.activateEffect(playerWithZZZs, board, userInput);
        assertEquals("Pillow should move down by 1 for player with ZZZs", initialPillowPosition - 1, playerWithZZZs.getPillowPosition());
    }

    @Test
    public void testActivateEffectConsumesZZZForPlayerWithoutInfiniteZZZs() {
        int initialZZZs = playerWithoutInfiniteZZZs.getNumOfZzzs();
        coolKidsClubTile.activateEffect(playerWithoutInfiniteZZZs, board, userInput);
        assertEquals("ZZZs should decrease by 1 for player without infinite ZZZs", initialZZZs - 1, playerWithoutInfiniteZZZs.getNumOfZzzs());
    }

    @Test
    public void testActivateEffectWhenPlayerHas0ZZZs() {
        // Assuming the effect is not applied and ZZZs do not go negative
        int initialPillowPosition = playerWith0ZZZs.getPillowPosition();
        coolKidsClubTile.activateEffect(playerWith0ZZZs, board, userInput);
        assertEquals("Pillow position should not change when player has 0 ZZZs", initialPillowPosition, playerWith0ZZZs.getPillowPosition());
    }



}
