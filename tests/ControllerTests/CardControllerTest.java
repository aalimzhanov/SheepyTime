package tests.ControllerTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.CardController;

import static org.junit.jupiter.api.Assertions.*;
import models.Card;
import views.CardView;
import views.UserInput;
import models.Player;
import models.cards.MoveSpacesCard;
import models.GameBoard;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CardControllerTest {

    private CardController cardController;
    private Card card;
    private CardView cardView;
    private UserInput userInput;

    @BeforeEach
    void setUp() {
        card = new MoveSpacesCard(1);
        cardView = new CardView();
        userInput = new UserInput();
        cardController = new CardController(card, cardView, userInput);
    }

    @Test
    void testUpdateView() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        cardController.updateView();
        System.setOut(originalOut);
        String printedOutput = outputStream.toString().trim();

        // Assert the expected output
        assertEquals("Move one space", printedOutput, "The card information should be printed.");
    }

    @Test
    void testGetCardInformation() {
        assertEquals("Move one space", cardController.getCardInformation(), "The card information should be returned.");
    }

    @Test
    void testExecuteCardAction() {
        Player player = new Player("Adil","blue");
        GameBoard gameBoard = new GameBoard();
        gameBoard.placeMovable(player, 1);
        cardController.executeCardAction(player, gameBoard);
        assertEquals(2, gameBoard.getMovablePosition(player), "Player should move to the next space.");
    }
    @Test
    void testExecuteCardAction2() {
        Player player = new Player("Adil","blue");
        GameBoard gameBoard = new GameBoard();
        gameBoard.placeMovable(player, 10);
        cardController.executeCardAction(player, gameBoard);
        assertEquals(1, gameBoard.getMovablePosition(player), "Player should wrap around to the first space.");
    }
    @Test
    void testExecuteCardAction3() {
        Player player = new Player("Adil","blue");
        GameBoard gameBoard = new GameBoard();
        CardController cardController = new CardController(new MoveSpacesCard(-1), cardView, userInput);
        gameBoard.placeMovable(player, 1);
        cardController.executeCardAction(player, gameBoard);
        assertEquals(1, gameBoard.getMovablePosition(player), "Player should not cross the fence backwards.");
    }
}