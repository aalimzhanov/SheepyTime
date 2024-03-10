package tests;
// We need helper getter methods such as isTurnEnded, isPlayerAwake
import controllers.ScoreBoardController;
import models.Player;
import models.ScoreBoard;
import views.ScoreBoardView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoardControllerTest {

    private ScoreBoardController scoreBoardController;
    private ScoreBoard scoreBoard;
    private ScoreBoardView view;
    private Player player;

    @BeforeEach
    void setUp() {
    player = new Player("tolga", "blue", "1"); // You may need to replace this with your actual Player implementation
    List<Player> players = new ArrayList<>();
    players.add(player);
    scoreBoard = new ScoreBoard(players); // You may need to replace this with your actual ScoreBoard implementation
    view = new ScoreBoardView(); // You may need to replace this with your actual ScoreBoardView implementation
    scoreBoardController = new ScoreBoardController(scoreBoard, view);
}

    @Test
    void testMovePillow() {
        int amount = 1;
        scoreBoardController.movePillow(player, amount);
        // for some reason this does not want to work, expected 1 got 41
        assertEquals(amount, scoreBoard.getPillowPosition(player), "The pillow should be moved by the specified amount");
    }

    @Test
    void testGainWinks() {
        int amount = 1;
        scoreBoardController.gainWinks(player, amount);
        assertEquals(amount, scoreBoard.getWinks(player), "The player should gain the specified amount of winks");
    }

    @Test
    void testWakeUp() {
        scoreBoardController.wakeUp(player);

        assertTrue(scoreBoard.isAwake(player), "The player should be awake");
    }

    @Test
    void testEndOfTurn() {
        scoreBoardController.endOfTurn();

        assertTrue(scoreBoard.isTurnEnded(), "The turn should be ended");
    }

    @Test
    void testIsGameOver() {

        assertFalse(scoreBoardController.isGameOver(), "The game should not be over");
    }

    @Test
    void testGetScoreBoard() {
        assertEquals(scoreBoard, scoreBoardController.getScoreBoard(), "The returned score board should be the same as the one set in the constructor");
    }

    @Test
    void testUpdateView() {
        // Since it's hard to test view updates, we can at least ensure it doesn't throw an exception
        assertDoesNotThrow(() -> scoreBoardController.updateView());
    }
}