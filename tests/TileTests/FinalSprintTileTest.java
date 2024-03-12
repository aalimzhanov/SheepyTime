package TileTests;

import models.GameBoard;
import models.Player;
import models.tiles.FinalSprintTile;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FinalSprintTileTest {

    private Player scaredPlayerWithZZZs;
    private Player scaredPlayerWithInfiniteZZZs;
    private Player notScaredPlayer;
    private FinalSprintTile finalSprintTile;
    private GameBoard board; 
    private UserInput userInput; 

    @Before
    public void setUp() {
        finalSprintTile = new FinalSprintTile();
        board = new GameBoard(); 
        userInput = new UserInput(); 
        
        scaredPlayerWithZZZs = new Player("scared player with ZZZs", "red");
        scaredPlayerWithZZZs.becomeScared();
        scaredPlayerWithZZZs.catchZZZs(5); 

        scaredPlayerWithInfiniteZZZs = new Player("scared player with infinite ZZZs", "blue");
        scaredPlayerWithInfiniteZZZs.becomeScared();
        
        notScaredPlayer = new Player("not scared player", "yellow");
    }

    @Test
    public void testActivateEffectMovesScaredPlayerForward() {
        int initialPosition = board.getMovablePosition(scaredPlayerWithZZZs);
        finalSprintTile.activateEffect(scaredPlayerWithZZZs, board, userInput);
        assertEquals("Scared player should move forward 7 spaces", initialPosition + 7, board.getMovablePosition(scaredPlayerWithZZZs));
    }

    @Test
    public void testActivateEffectDecrementsZZZsForScaredPlayerWithFiniteZZZs() {
        int initialZZZs = scaredPlayerWithZZZs.getNumOfZzzs();
        finalSprintTile.activateEffect(scaredPlayerWithZZZs, board, userInput);
        assertEquals("ZZZs should be decreased by 1 for scared player with finite ZZZs", initialZZZs - 1, scaredPlayerWithZZZs.getNumOfZzzs());
    }

    @Test
    public void testActivateEffectDoesNotDecrementZZZsForScaredPlayerWithInfiniteZZZs() {
        int initialZZZs = scaredPlayerWithInfiniteZZZs.getNumOfZzzs(); 
        finalSprintTile.activateEffect(scaredPlayerWithInfiniteZZZs, board, userInput);
        assertEquals("ZZZs should not be decreasd for scared player with infinite ZZZs", initialZZZs, scaredPlayerWithInfiniteZZZs.getNumOfZzzs());
    }

    @Test
    public void testActivateEffectDoesNotMoveNotScaredPlayer() {
        int initialPosition = board.getMovablePosition(notScaredPlayer);
        finalSprintTile.activateEffect(notScaredPlayer, board, userInput);
        assertEquals("Not scared player should not move", initialPosition, board.getMovablePosition(notScaredPlayer));
    }

}
