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
            Card card1 = new MoveSpacesCard(1);
            Card card2 = new MoveSpacesCard(5);
            deck.addCard(new OrComboCard(new Card[] { card1, card2 }));
        }
        for (int i = 0; i < 7; i++) {
            Card card1 = new MoveSpacesCard(4);
            Card card2 = new CatchZzzCard(1);
            deck.addCard(new OrComboCard(new Card[] { card1, card2 }));
        }
        for (int i = 0; i < 2; i++) {
            Card card1 = new MoveSpacesCard(1);
            Card card2 = new CatchZzzCard(1);
            deck.addCard(new AndComboCard(new Card[] { card1, card2 }));
        }
        for (int i = 0; i < 2; i++) {
            Card card1 = new MoveSpacesCard(1);
            Card card2 = new MoveSpacesCard(2);
            Card card3 = new OrComboCard(new Card[] { card1, card2 });
            Card card4 = new CatchZzzCard(1);
            deck.addCard(new AndComboCard(new Card[] { card3, card4 }));
        }
        for (int i = 0; i < 2; i++) {
            Card card1 = new MoveSpacesCard(5);
            Card card2 = new GainWinksCard(2);
            deck.addCard(new OrComboCard(new Card[] { card1, card2 }));
        }
        for (int i = 0; i < 3; i++) {
            Card card1 = new MoveSpacesCard(2);
            Card card2 = new CatchZzzCard(2);
            deck.addCard(new OrComboCard(new Card[] { card1, card2 }));
        }
        for (int i = 0; i < 3; i++) {
            Card card1 = new MoveSpacesCard(6);
            Card card2 = new GainWinksCard(3);
            deck.addCard(new OrComboCard(new Card[] { card1, card2 }));
        }
        for (int i = 0; i < 7; i++) {
            Card card1 = new MoveSpacesCard(3);
            Card card2 = new CatchZzzCard(1);
            deck.addCard(new OrComboCard(new Card[] { card1, card2 }));
        }

        for (int i = 0; i < 2; i++) {
            deck.addCard(new CatchZzzCard(2));
        }

        DeckController deckController = new DeckController(deck);
        return deckController;
    }
}
