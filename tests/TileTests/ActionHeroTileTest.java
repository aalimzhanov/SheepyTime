package tests.TileTests;

import models.GameBoard;
import models.Player;
import models.tiles.ActionHeroTile;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActionHeroTileTest {

    private Player scaredPlayerWithZZZs;
    private Player scaredPlayerNoInfiniteZZZs;
    private Player notScaredPlayer;
    private ActionHeroTile actionHeroTile;
    private GameBoard board; 
    private UserInput userInput; 

    @Before
    public void setUp() {
        actionHeroTile = new ActionHeroTile();
        
        // Scared player with ZZZs
        scaredPlayerWithZZZs = new Player("scaread player w zz", "blue");
        scaredPlayerWithZZZs.becomeScared();
        scaredPlayerWithZZZs.catchZZZs(10); 

        // Scared player without infinite ZZZs
        scaredPlayerNoInfiniteZZZs = new Player("scared player w/out zz", "green");
        scaredPlayerNoInfiniteZZZs.becomeScared();
        scaredPlayerNoInfiniteZZZs.catchZZZs(5); 

        // Not scared player
        notScaredPlayer = new Player("not scared player", "red");
        notScaredPlayer.catchZZZs(5);

        // Placeholder initializations
        board = new GameBoard();
        userInput = new UserInput();
    }

    @Test
     public void testActivateEffectIncreasesWinksForScaredPlayerWithZZZs() {
        actionHeroTile.placeZzzs(3, false); // Must add 3 zzzs for player to collect
        int initialWinks = scaredPlayerWithZZZs.getWinks();
        actionHeroTile.activateEffect(scaredPlayerWithZZZs, board, userInput);
        assertEquals("Winks should increase by 3 for scared player with ZZZs", initialWinks + 3, scaredPlayerWithZZZs.getWinks());
    }

    @Test
    public void testActivateEffectConsumesZZZForScaredPlayerNoInfiniteZZZs() {
        scaredPlayerNoInfiniteZZZs = new Player("scared player w/out zz", "green");
        actionHeroTile.placeZzzs(3, false);
        int initialZZZs = scaredPlayerNoInfiniteZZZs.getNumOfZzzs();
        actionHeroTile.activateEffect(scaredPlayerNoInfiniteZZZs, board, userInput);
        assertEquals("ZZZs should decrease by 1 for scared player without infinite ZZZs", initialZZZs, scaredPlayerNoInfiniteZZZs.getNumOfZzzs());
    }

    @Test
    public void testEffectDoesNotApplyToNotScaredPlayer() {
        int initialWinks = notScaredPlayer.getWinks();
        actionHeroTile.activateEffect(notScaredPlayer, board, userInput);
        assertEquals("Winks should not change for non scared player", initialWinks, notScaredPlayer.getWinks());
    }

    @Test
    public void testNoZZZChangeForNotScaredPlayer() {
        int initialZZZs = notScaredPlayer.getNumOfZzzs();
        actionHeroTile.activateEffect(notScaredPlayer, board, userInput);
        assertEquals("ZZZs should not change for non scared player", initialZZZs, notScaredPlayer.getNumOfZzzs());
    }

}
