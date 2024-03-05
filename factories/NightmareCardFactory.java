package factories;

import models.Deck;
import models.cards.JumpNightmareCard;
import models.cards.MoveNightmareCard;
import models.cards.ScareNightmareCard;

public class NightmareCardFactory {
    public static void createNightmareCards(Deck deck, String nightmareChoice) {
        switch (nightmareChoice) {
            case "Wolf":
                addMoveNightmareCards(deck, 4, 2);
                addMoveNightmareCards(deck, 4, 1);
                addScareNightmareCards(deck, 2);
                break;
            case "BumpInTheNight":
                addJumpNightmareCards(deck, 3, -1);
                addJumpNightmareCards(deck, 4, 2);
                addJumpNightmareCards(deck, 2, 3);
                deck.addCard(new JumpNightmareCard(1));
                break;
            case "Spider":
                // Spider cards to be added
                break;
            default:
                break;
        }
        deck.shuffleDeck();
    }
    
    private static void addMoveNightmareCards(Deck deck, int count, int moveAmount) {
        for (int i = 0; i < count; i++) {
            deck.addCard(new MoveNightmareCard(moveAmount));
        }
    }
    
    private static void addJumpNightmareCards(Deck deck, int count, int jumpAmount) {
        for (int i = 0; i < count; i++) {
            deck.addCard(new JumpNightmareCard(jumpAmount));
        }
    }
    
    private static void addScareNightmareCards(Deck deck, int count) {
        for (int i = 0; i < count; i++) {
            deck.addCard(new ScareNightmareCard());
        }
    }
}
