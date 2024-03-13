package tests.ModelTests;
import controllers.GameBoardController;
import controllers.PlayerController;
import controllers.TileController;
import models.GameBoard;
import models.Player;
import models.RestingPhaseLogic;
import models.TileDeck;
import models.tiles.ActionHeroTile;
import views.GameBoardView;
import views.PlayerView;
import views.TileView;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestingPhaseLogicTest {

    private GameBoardController gameBoardController;
    private PlayerController playerController;
    private TileDeck tileDeck;
    private RestingPhaseLogic restingPhaseLogic;
    private UserInput userInput;

    @Before
    public void setUp() {
        GameBoard gameBoard = new GameBoard(); 
        GameBoardView gameBoardView = new GameBoardView(); 
        gameBoardController = new GameBoardController(gameBoard, gameBoardView);

        Player player = new Player("tolga", "blue");
        PlayerView playerView = new PlayerView(); 
        playerController = new PlayerController(player, playerView);

        tileDeck = new TileDeck();
        ActionHeroTile actionHeroTile = new ActionHeroTile();
        TileView tileView = new TileView(); 
        TileController tileController = new TileController(actionHeroTile, tileView);
        tileDeck.addTile(tileController);

        // mocking UserInput as required for specific scenarios
        userInput = new UserInputStub();

        restingPhaseLogic = new RestingPhaseLogic();
    }

    // @Test
    // public void testPlayRestingMove() {
    //     int initialZZZs = playerController.getNumOfZzzs();
    //     restingPhaseLogic.playRestingMove(gameBoardController, userInput, tileDeck, playerController);
    //     int finalZZZs = playerController.getNumOfZzzs();

    //     assertNotEquals("Player ZZZs should change after playing resting move", initialZZZs, finalZZZs);
    // }

    // mocking UserInput
    private class UserInputStub extends UserInput {
        @Override
        public boolean getRestingMoveDecision() {
            return true; 
        }

    }
}
