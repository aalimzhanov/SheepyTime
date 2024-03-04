package models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Represents a deck of cards with functionalities to shuffle, draw, and play
 * cards.
 * 
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 * @version
 */
public class Deck {
    private Queue<Card> activeCards;
    private int playedCards;

    /**
     * Constructs a new Deck with empty active and played cards.
     */
    public Deck() {
        activeCards = new LinkedList<>();
        playedCards = 0;
    }

    /**
     * Shuffles the cards.
     */
    public void shuffleDeck() {
        List<Card> cardList = new LinkedList<>(activeCards);
        Collections.shuffle(cardList);
        activeCards = new LinkedList<>(cardList);
        playedCards = 0;
    }

    /**
     * Draws a card from the active cards queue. If the active cards queue is empty,
     * shuffles deck before drawing.
     *
     * @return The drawn card from the active cards queue, or null if no cards are
     *         available.
     */
    public Card drawCard() {
        if (isEmpty()) {
            shuffleDeck();
        }
        playedCards++;
        return activeCards.poll();
    }

    /**
     * Adds a new card.
     *
     * @param card The card to be added to the played cards list.
     */
    public void addCard(Card card) {
        activeCards.offer(card);
    }

    /**
     * Checks if all cards were played.
     *
     * @return true if all cards were played, false otherwise.
     */
    private boolean isEmpty() {
        return activeCards.size() == playedCards;
    }

}
