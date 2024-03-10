package tests;

import controllers.PlayerController;
import models.Player;
import models.Sheep;
import models.cards.OrComboCard;
import models.Card;
import views.PlayerView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerControllerTest {

    private PlayerController playerController;
    private Player player;
    private PlayerView view;

    @BeforeEach
    void setUp() {
        player = new Player("tolga", "blue", "1"); 
        view = new PlayerView(); 
        playerController = new PlayerController(player, view);
    }

    @Test
    void testUpdateView() {
        assertDoesNotThrow(() -> playerController.updateView());
    }

    @Test
    void testGetPlayerName() {
        String expectedName = "tolga";
        assertEquals(expectedName, playerController.getPlayerName(), "The name should be the expected name");
    }

    @Test
    void testGetSheep() {
        Sheep expectedSheep = new Sheep("blue"); 
        assertEquals(expectedSheep, playerController.getSheep(), "The sheep should be the expected sheep");
    }

    @Test
    void testGetNumOfZzzs() {
        int expectedNumOfZzzs = 0;
        assertEquals(expectedNumOfZzzs, playerController.getNumOfZzzs(), "The number of Zzzs should be the expected number");
    }

    @Test
    void testGainCard() {
        OrComboCard card = new OrComboCard(null);
        playerController.gainCard(card);
        // Guys no clue how to test this method, edit this for me please
        assertTrue(player.hasCard(card), "The player should have the card that was gained");
    }

    @Test
    void testNeedsACard() {
        assertTrue(playerController.needsACard(), "The player should need a card if the hand is empty");
    }

    @Test
    void testPlayCard() {
        Card card = new OrComboCard(null); 
        player.gainCard(card);
        assertEquals(card, playerController.playCard(0), "The played card should be the card that was gained");
    }

    @Test
    void testCatchZZZs() {
        int amount = 1;
        assertEquals(amount, playerController.catchZZZs(amount), "The player should catch the specified amount of Zzzs");
    }

    @Test
    void testGetModel() {
        assertEquals(player, playerController.getModel(), "The returned model should be the same as the one set in the constructor");
    }
}