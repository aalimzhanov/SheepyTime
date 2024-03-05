package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.BumpInTheNight;

import static org.junit.jupiter.api.Assertions.*;

class BumpInTheNightTest {

    private BumpInTheNight bumpInTheNight;

    @BeforeEach
    void setUp() {
        bumpInTheNight = new BumpInTheNight();
    }

    @Test
    void testName() {
        assertEquals("Bump In The Night", bumpInTheNight.getName(), "The name should be 'Bump In The Night'");
    }

    @Test
    void testDescription() {
        assertEquals("Big scary Bump In The Night", bumpInTheNight.getDescription(), "The description should be 'Big scary Bump In The Night'");
    }

    @Test
    void testDifficulty() {
        assertEquals(3, bumpInTheNight.getDifficulty(), "The difficulty should be 3");
    }
}
