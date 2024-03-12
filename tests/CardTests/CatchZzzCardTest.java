package tests.CardTests;

import models.cards.CatchZzzCard;
import models.GameBoard;
import models.Player;
import views.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatchZzzCardTest {

    private CatchZzzCard catchZzzCard;
    private Player player;
    private GameBoard gameBoard;
    private UserInput input;

    @BeforeEach
    void setUp() {
        int zzzs = 1;
        catchZzzCard = new CatchZzzCard(zzzs);
        player = new Player("tolga","blue"); 
        gameBoard = new GameBoard(); 
    }

    @Test
    void testGetInformation() {
        String expectedInformation = "Catch 1 zzz";
        assertEquals(expectedInformation, catchZzzCard.getInformation(), "The information should be the expected information");
    }

    @Test
    void testExecuteAction() {
        assertDoesNotThrow(() -> catchZzzCard.executeAction(player, gameBoard, input));
    }

    @Test
    void testIsNightmare() {
        assertFalse(catchZzzCard.isNightmare(), "The card should not be a nightmare");
    }
}