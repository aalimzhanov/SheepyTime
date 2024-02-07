/**
 * Represents a NightmareCard.
 * 
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 * @version 
 */
public class NightmareCard implements Card {
    private ActionType actionType;
    private int actionValue;
    private int difficulty;

    /**
     * Constructs a new NightmareCard.
     *
     * @param actionType The type of action this card represents.
     * @param actionValue The value associated with the card's action.
     * @param difficulty The difficulty level of the card.
     */
    public NightmareCard(ActionType actionType, int actionValue, int difficulty) {
        this.actionType = actionType;
        this.actionValue = actionValue;
        this.difficulty = difficulty;
    }

    /**
     * Returns the action type of this card.
     *
     * @return The action type of the card.
     */
    public ActionType getActionType() {
        return actionType;
    }

    /**
     * Returns the action value of this card.
     *
     * @return The action value associated with the card's action.
     */
    public int getActionValue() {
        return actionValue;
    }

    /**
     * Returns the difficulty level of this card.
     *
     * @return The difficulty level of the card.
     */
    public int getDifficulty() {
        return difficulty;
    }
}

