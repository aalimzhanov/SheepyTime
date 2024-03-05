package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WolfTest {
    
    private Wolf wolf;

    @BeforeEach
    void setUp() {
        wolf = new Wolf();
    }

    @Test
    void testGetName() {
        assertEquals("Wolf", wolf.getName(), "The name should correctly be 'Wolf'");
    }

    @Test
    void testGetDescription() {
        assertEquals("Big scary wolf", wolf.getDescription(), "The description should correctly be 'Big scary wolf'");
    }

    @Test
    void testGetDifficulty() {
        assertEquals(1, wolf.getDifficulty(), "The difficulty level should correctly be 1");
    }
}
