package tests.FactoryTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import factories.TileDeckFactory;
import models.TileDeck;

public class TileDeckFactoryTest {

    @Test
    public void testCreateTiles() {
        TileDeck deck = TileDeckFactory.createTiles();
        assertEquals(4, deck.getNumOfTiles(), "Tile market should have 4 tiles");
    }

}