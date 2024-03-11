package tests.CardTests;

import models.cards.MoveSpacesCard;
import models.GameBoard;
import models.Player;
import views.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveSpacesCardTest {

    private MoveSpacesCard moveSpacesCard;
    private Player player;
    private GameBoard gameBoard;
    private UserInput input;

    @BeforeEach
    void setUp() {
        int spaces = 1;
        moveSpacesCard = new MoveSpacesCard(spaces);
        player = new Player("tolga","blue"); 
        gameBoard = new GameBoard(); 
        input = new UserInput(); 
    }

    @Test
    void testGetInformation() {
        String expectedInformation = "Move one space";
        assertEquals(expectedInformation, moveSpacesCard.getInformation(), "The information should be the expected information");
    }

    @Test
    void testExecuteAction() {
        assertDoesNotThrow(() -> moveSpacesCard.executeAction(player, gameBoard, input));
    }

    @Test
    void testIsNightmare() {
        assertFalse(moveSpacesCard.isNightmare(), "The card should not be a nightmare");
    }
}