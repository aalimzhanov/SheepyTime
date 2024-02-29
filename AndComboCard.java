public class AndComboCard implements Card {
    private Card[] actions;

    public AndComboCard(Card[] actions) {
        this.actions = actions;
    }

    @Override
    public void executeAction(PlayerController playerController, GameBoard gameBoard, UserInput input) {
        for (Card action : actions) {
            action.executeAction(playerController, gameBoard, input);
        }
    }

    @Override
    public String getInformation() {
        return actions[0].getInformation() + " and " + actions[1].getInformation();
    }
}
