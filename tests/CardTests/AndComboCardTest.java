package tests.CardTests;

import models.Card;
import models.GameBoard;
import models.Player;
import models.cards.AndComboCard;
import models.cards.MoveSpacesCard;
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
        actions = new Card[]{new MoveSpacesCard(2), new MoveSpacesCard(3)};
        andComboCard = new AndComboCard(actions);
        player = new Player("Adil","blue"); 
        gameBoard = new GameBoard();
        gameBoard.placeMovable(player, 1);
    }

    @Test
    void testExecuteAction() {
        andComboCard.executeAction(player, gameBoard, input);
        assertEquals(6, gameBoard.getMovablePosition(player), "The player should be at position 6");
     }

    @Test
    void testGetInformation() {
        String expectedInformation = "Move 2 spaces and Move 3 spaces";
        assertEquals(expectedInformation, andComboCard.getInformation(), "The information should be the expected information");
    }

    @Test
    void testIsNightmare() {
        assertFalse(andComboCard.isNightmare(), "The card should not be a nightmare");
    }
}