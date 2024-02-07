/**
 * Defines the functionality of cards
 */
public interface Card {
    
    /**
     * Retrieves the action type of the card. 
     * @return The action type of the card.
     */
    ActionType getActionType();
    
    /**
     * Retrieves the action value of the card. 
     * 
     * @return The action value of the card.
     */
    int getActionValue();
}
