package tests.CardTests;

import models.cards.ScareNightmareCard;
import models.GameBoard;
import models.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScareNightmareCardTest {

    @Test
    public void testExecuteAction() {
        ScareNightmareCard card = new ScareNightmareCard();
        GameBoard gameBoard = new GameBoard();
        Player player = new Player("tolga", "blue");
        card.executeAction(player, gameBoard, null);
        int expectedNightmarePos = 0;
        assertEquals(expectedNightmarePos, gameBoard.getNightmarePos());
    }

    @Test
    public void testGetInformation() {
        ScareNightmareCard card = new ScareNightmareCard();
        String info = card.getInformation();
        assertEquals("The nightmare scares all sheep on it space and adjacent spaces.", info);
    }

    @Test
    public void testIsNightmare() {
        ScareNightmareCard card = new ScareNightmareCard();
        assertTrue(card.isNightmare());
    }
}