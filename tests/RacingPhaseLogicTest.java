// FILEPATH: /c:/Users/tolga/Downloads/SheepyTime/tests/RacingPhaseLogicTest.java

package tests;

import controllers.DeckController;
import controllers.GameBoardController;
import controllers.PlayerController;
import models.Card;
import models.Deck;
import models.GameBoard;
import models.Player;
import models.RacingPhaseLogic;
import models.cards.OrComboCard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import views.GameBoardView;
import views.PlayerView;
import views.UserInput;

import static org.junit.jupiter.api.Assertions.*;

public class RacingPhaseLogicTest {
    private PlayerController playerController;
    private GameBoardController gameBoardController;
    private DeckController deckController;
    private UserInput userInput;
    private RacingPhaseLogic racingPhaseLogic;

    @BeforeEach
    public void setup() {
        Player player = new Player("tolga", "blue");
        PlayerView playerview = new PlayerView();
        playerController = new PlayerController(player, playerview);
        GameBoard gameBoard = new GameBoard();
        GameBoardView gameBoardView = new GameBoardView();
        gameBoardController = new GameBoardController(gameBoard, gameBoardView);
        Deck deck = new Deck();
        deckController = new DeckController(deck);
        userInput = new UserInput();
        racingPhaseLogic = new RacingPhaseLogic();
    }

    @Test
    public void testPlayRacingMove() {
        playerController.setNeedsACard(true);
        Card card = new OrComboCard(null); 
        card.setIsNightmare(false);
        deckController.addCard(card);

        racingPhaseLogic.playRacingMove(playerController, gameBoardController, deckController, userInput);

        assertFalse(playerController.needsACard());
    }

    @Test
    public void testCheckFence() {
        Player player = new Player(); 
        player.crossFence();
        userInput.setCallItANightDecision(true);

        racingPhaseLogic.checkFence(gameBoardController, player, userInput);

        assertFalse(player.hasCrossedFence());
    }
}