package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Spider;

import static org.junit.jupiter.api.Assertions.*;

class SpiderTest {

    private Spider spider;

    @BeforeEach
    void setUp() {
        spider = new Spider();
    }

    @Test
    void testName() {
        assertEquals("Spider", spider.getName(), "The name should be correctly initialized");
    }

    @Test
    void testDescription() {
        assertEquals("THIS WEB IS PRETTY RELAXING, KINDA LIKE A HAMMOCK! AND I'M SURE I CAN GET FREE BEFORE THE SINISTER SPIDER COMES BACK. *WEB SHAKES* IT IS RATHER STICKY, THOUGH. CAN SOMEONE HELP ME OUT? *SHAKING\r\n" +
                "INTENSIFIES* GET ME OUTTA HERE!!!", spider.getDescription(), "The description should be correctly initialized");
    }

    @Test
    void testDifficulty() {
        assertEquals(2, spider.getDifficulty(), "The difficulty level should be correctly initialized");
    }
}
