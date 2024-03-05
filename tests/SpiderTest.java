package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        assertEquals("Big scary spider", spider.getDescription(), "The description should be correctly initialized");
    }

    @Test
    void testDifficulty() {
        assertEquals(2, spider.getDifficulty(), "The difficulty level should be correctly initialized");
    }
}
