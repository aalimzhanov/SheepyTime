// FILEPATH: /c:/Users/tolga/Downloads/SheepyTime/tests/CardTests/JumpNightmareCardTest.java

package tests.CardTests;

import models.cards.JumpNightmareCard;
import models.GameBoard;
import models.Player;
import views.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JumpNightmareCardTest {

    private JumpNightmareCard jumpNightmareCard;
    private Player player;
    private GameBoard gameBoard;
    private UserInput input;

    @BeforeEach
    void setUp() {
        int spaces = 1;
        jumpNightmareCard = new JumpNightmareCard(spaces);
        player = new Player("tolga","blue"); 
        gameBoard = new GameBoard();
    }

    @Test
    void testGetInformation() {
        String expectedInformation = "The nightmare jumps 1 spaces forward.";
        assertEquals(expectedInformation, jumpNightmareCard.getInformation(), "The information should be the expected information");
    }

    @Test
    void testExecuteAction() {
        assertDoesNotThrow(() -> jumpNightmareCard.executeAction(player, gameBoard, input));
    }

    @Test
    void testIsNightmare() {
        assertTrue(jumpNightmareCard.isNightmare(), "The card should be a nightmare");
    }
}