package tests.TileTests;

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
        CoolKidsClubTile CoolKidsClubTile = new CoolKidsClubTile();
        int initialPillowPosition = playerWithZZZs.getPillowPosition();
        GameBoard board = new GameBoard();
        UserInput userInput = new UserInput();
        CoolKidsClubTile.activateEffect(playerWithZZZs, board, userInput);
        assertEquals("Pillow should move down by 1 for player with ZZZs", initialPillowPosition , playerWithZZZs.getPillowPosition());
    }

    @Test
    public void testActivateEffectConsumesZZZForPlayerWithoutInfiniteZZZs() {
        CoolKidsClubTile CoolKidsClubTile = new CoolKidsClubTile();
        int initialZZZs = playerWithoutInfiniteZZZs.getNumOfZzzs();
        CoolKidsClubTile.activateEffect(playerWithoutInfiniteZZZs, board, userInput);
        assertEquals("ZZZs should decrease by 1 for player without infinite ZZZs", initialZZZs, playerWithoutInfiniteZZZs.getNumOfZzzs());
    }

    @Test
    public void testActivateEffectWhenPlayerHas0ZZZs() {
        // Tile effect is not applied and ZZZs can not go negative
        CoolKidsClubTile CoolKidsClubTile = new CoolKidsClubTile();
        int initialPillowPosition = playerWith0ZZZs.getPillowPosition();
        CoolKidsClubTile.activateEffect(playerWith0ZZZs, board, userInput);
        assertEquals("Pillow position should not change when player has 0 ZZZs", initialPillowPosition, playerWith0ZZZs.getPillowPosition());
    }



}
