package tests.CardTests;

import models.cards.MoveNightmareCard;
import models.GameBoard;
import models.Player;
import views.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveNightmareCardTest {

    private MoveNightmareCard moveNightmareCard;
    private Player player;
    private GameBoard gameBoard;
    private UserInput input;

    @BeforeEach
    void setUp() {
        int spaces = 1;
        moveNightmareCard = new MoveNightmareCard(spaces);
        player = new Player("tolga","blue"); 
        gameBoard = new GameBoard(); 
        input = new UserInput(); 
    }

    @Test
    void testGetInformation() {
        String expectedInformation = "The nightmare moves 1 spaces forward.";
        assertEquals(expectedInformation, moveNightmareCard.getInformation(), "The information should be the expected information");
    }

    @Test
    void testExecuteAction() {
        assertDoesNotThrow(() -> moveNightmareCard.executeAction(player, gameBoard, input));
    }

    @Test
    void testIsNightmare() {
        assertTrue(moveNightmareCard.isNightmare(), "The card should be a nightmare");
    }
}