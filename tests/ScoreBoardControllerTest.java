package tests;

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
        player = new Player("tolga", "blue");
        List<Player> players = new ArrayList<>();
        players.add(player);
        scoreBoard = new ScoreBoard(players);
        view = new ScoreBoardView();
        scoreBoardController = new ScoreBoardController(scoreBoard, view);
    }

    @Test
    void testMovePillow() {
        int amount = -1;
        scoreBoardController.movePillow(player, amount);
        assertEquals(40+amount, scoreBoard.getPillowPosition(player),
                "The pillow should be moved by the specified amount");
    }

    @Test
    void testGainWinks() {
        int amount = 1;
        scoreBoardController.gainWinks(player, amount);
        assertEquals(amount, scoreBoard.getWinks(player), "The player should gain the specified amount of winks");
    }

    @Test
    void testWakeUp() {
        player.gainWinks(2);
        scoreBoardController.wakeUp(player);

        assertEquals(0, scoreBoard.getWinks(player), "The player should have no winks");
    }

    @Test
    void testEndOfTurn() {
        player.gainWinks(6);
        scoreBoardController.endOfTurn();
        assertEquals(39, scoreBoard.getPillowPosition(player), "The player should move their pillow back by one for every 5 winks");
        assertEquals(0, scoreBoard.getWinks(player), "The player should have no winks");
    }

    @Test
    void testIsGameOver() {
        assertFalse(scoreBoardController.isGameOver(), "The game should not be over");
        scoreBoard.movePillow(player, -35);
        scoreBoard.gainWinks(player, 6);
        assertTrue(scoreBoardController.isGameOver(), "The game should be over");
    }

    @Test
    void testGetScoreBoard() {
        assertEquals(scoreBoard, scoreBoardController.getScoreBoard(),
                "The returned score board should be the same as the one set in the constructor");
    }

    @Test
    void testUpdateView() {
        assertDoesNotThrow(() -> scoreBoardController.displayScoreBoard());
    }
}