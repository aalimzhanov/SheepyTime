package models;
public class AndComboCard implements Card {
    private Card[] actions;

    public AndComboCard(Card[] actions) {
        this.actions = actions;
    }

    @Override
    public void executeAction(Player player, GameBoard gameBoard) {
        for (Card action : actions) {
            action.executeAction(player, gameBoard);
        }
    }

    @Override
    public String getInformation() {
        return actions[0].getInformation() + " and " + actions[1].getInformation();
    }

    @Override
    public boolean isNightmare() {
        return false;
    }
    
}
