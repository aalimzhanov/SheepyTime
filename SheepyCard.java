/**
 * Represents a SheepyCard.
 * 
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 * @version 
 */
public class SheepyCard implements Card {
    private ActionType actionType;
    private int actionValue;

    /**
     * Constructs a new SheepyCard.
     *
     * @param actionType The type of action this card represents, indicating what action should be taken when the card is played.
     * @param actionValue The value associated with the card's action, which may affect the magnitude or effect of the action.
     */
    public SheepyCard(ActionType actionType, int actionValue) {
        this.actionType = actionType;
        this.actionValue = actionValue;
    }

    /**
     * Returns the action type of this card.
     *
     * @return The action type of the card, defining the category or nature of the action it represents.
     */
    public ActionType getActionType() {
        return actionType;
    }

    /**
     * Returns the action value of this card.
     *
     * @return The action value associated with the card's action, indicating its strength, impact, or other quantitative measure.
     */
    public int getActionValue() {
        return actionValue;
    }
}
