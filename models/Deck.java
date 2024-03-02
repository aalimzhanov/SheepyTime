package models;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Represents a deck of cards with functionalities to shuffle, draw, and play cards.
 * 
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 * @version 
 */
public class Deck
{
    private Queue<Card> activeCards;
    private List<Card> playedCards;
    
    /**
     * Constructs a new Deck with empty active and played cards.
     */
    public Deck() {
        activeCards = new LinkedList<>();
        playedCards = new LinkedList<>();
    }

    /**
     * Shuffles the played cards and transfers them to the active cards queue.
     */
    public void shuffleDeck() {
        Collections.shuffle(playedCards);
        transferCards();
    }

    /**
     * Draws a card from the active cards queue. If the active cards queue is empty,
     * shuffles the played cards and transfers them to the active cards queue before drawing.
     *
     * @return The drawn card from the active cards queue, or null if no cards are available.
     */
    public Card drawACard() {
        if (isEmpty()) {
            shuffleDeck();
        }
        return activeCards.poll();
    }

    /**
     * Adds a played card to the played cards list.
     *
     * @param playedCard The card to be added to the played cards list.
     */
    public void playACard(Card playedCard) {
        playedCards.add(playedCard);
    }

    /**
     * Checks if the active cards queue is empty.
     *
     * @return true if the active cards queue is empty, false otherwise.
     */
    private boolean isEmpty() {
        return activeCards.isEmpty();
    }

    /**
     * Transfers all cards from the played cards list to the active cards queue.
     * This method is used internally to refill the active cards queue after shuffling.
     */
    private void transferCards() {
        while (!playedCards.isEmpty()) {
            activeCards.add(playedCards.remove(0));
        }
    }
}
