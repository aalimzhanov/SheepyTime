package tests.FactoryTests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import factories.NightmareCardFactory;
import models.Deck;

public class NightmareCardFactoryTest {

    @Test
    public void testCreateNightmareCards_Wolf() {
        Deck deck = new Deck();
        String nightmareChoice = "Wolf";
        NightmareCardFactory.createNightmareCards(deck, nightmareChoice);
        assertNotNull(deck.drawCard(), "Deck should not be empty");
    }

    @Test
    public void testCreateNightmareCards_BumpInTheNight() {
        Deck deck = new Deck();
        String nightmareChoice = "BumpInTheNight";
        NightmareCardFactory.createNightmareCards(deck, nightmareChoice);
        assertNotNull(deck.drawCard(), "Deck should not be empty");
    }

}