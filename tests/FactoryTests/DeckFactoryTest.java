package tests.FactoryTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import factories.DeckFactory;
import controllers.DeckController;

public class DeckFactoryTest {

    @Test
    public void testCreateDeck_ReturnsDeckController() {
        DeckController deckController = DeckFactory.createDeck();

        assertNotNull(deckController);
        assertNotNull(deckController.drawCard());
    }
}