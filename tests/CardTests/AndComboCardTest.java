package tests.CardTests;

import models.Card;
import models.GameBoard;
import models.Player;
import models.cards.AndComboCard;
import views.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AndComboCardTest {

    private AndComboCard andComboCard;
    private Card[] actions;
    private Player player;
    private GameBoard gameBoard;
    private UserInput input;

    @BeforeEach
    void setUp() {
        actions = new Card[]{}; // You may need to replace this with your actual Card array
        andComboCard = new AndComboCard(actions);
        player = new Player("tolga","blue"); 
        gameBoard = new GameBoard();
    }

    @Test
    void testExecuteAction() {
        assertDoesNotThrow(() -> andComboCard.executeAction(player, gameBoard, input), "executeAction should not throw an exception");
    }

    @Test
    void testGetInformation() {
        String expectedInformation = "";
        assertEquals(expectedInformation, andComboCard.getInformation(), "The information should be the expected information");
    }

    @Test
    void testIsNightmare() {
        assertFalse(andComboCard.isNightmare(), "The card should not be a nightmare");
    }
}