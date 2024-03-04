package factories;

import controllers.DeckController;
import models.Card;
import models.Deck;
import models.cards.AndComboCard;
import models.cards.CatchZzzCard;
import models.cards.GainWinksCard;
import models.cards.MoveSpacesCard;
import models.cards.OrComboCard;

public class DeckFactory {
    public static DeckController createDeck() {
        Deck deck = new Deck();
        
        // Add all SheepyCards to the deck
        for (int i = 0; i < 2; i++) {
            deck.addCard(createOrComboCard(new MoveSpacesCard(1), new MoveSpacesCard(5)));
        }
        
        for (int i = 0; i < 7; i++) {
            deck.addCard(createOrComboCard(new MoveSpacesCard(4), new CatchZzzCard(1)));
        }
        
        for (int i = 0; i < 2; i++) {
            deck.addCard(createAndComboCard(new MoveSpacesCard(1), new CatchZzzCard(1)));
        }
        
        for (int i = 0; i < 2; i++) {
            Card card1 = new MoveSpacesCard(1);
            Card card2 = new MoveSpacesCard(2);
            Card card3 = createOrComboCard(card1, card2);
            Card card4 = new CatchZzzCard(1);
            deck.addCard(createAndComboCard(card3, card4));
        }
        
        for (int i = 0; i < 2; i++) {
            deck.addCard(createOrComboCard(new MoveSpacesCard(5), new GainWinksCard(2)));
        }
        
        for (int i = 0; i < 3; i++) {
            deck.addCard(createOrComboCard(new MoveSpacesCard(2), new CatchZzzCard(2)));
        }
        
        for (int i = 0; i < 3; i++) {
            deck.addCard(createOrComboCard(new MoveSpacesCard(6), new GainWinksCard(3)));
        }
        
        for (int i = 0; i < 7; i++) {
            deck.addCard(createOrComboCard(new MoveSpacesCard(3), new CatchZzzCard(1)));
        }

        for (int i = 0; i < 2; i++) {
            deck.addCard(new CatchZzzCard(2));
        }

        DeckController deckController = new DeckController(deck);
        return deckController;
    }
    
    private static Card createOrComboCard(Card card1, Card card2) {
        return new OrComboCard(new Card[] { card1, card2 });
    }
    
    private static Card createAndComboCard(Card card1, Card card2) {
        return new AndComboCard(new Card[] { card1, card2 });
    }
}
