package tests.FactoryTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import factories.GameBoardFactory;
import controllers.GameBoardController;

public class GameBoardFactoryTest {

    @Test
    public void testInitializeGameBoard() {
        GameBoardController gameBoardController = GameBoardFactory.initializeGameBoard();
        assertNotNull(gameBoardController);
        assertNotNull(gameBoardController.getModel());
    }
}