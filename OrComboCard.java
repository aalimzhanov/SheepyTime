public class OrComboCard implements Card {
    private Card[] actions;

    public OrComboCard(Card[] actions) {
        this.actions = actions;
    }

    @Override
    public void executeAction(PlayerController playerController, GameBoard gameBoard, UserInput input) {
        int userSelection = input.getSelection();
        if(userSelection == 1){
            actions[0].executeAction(playerController, gameBoard, input);
        }
        else if(userSelection == 2){
            actions[1].executeAction(playerController, gameBoard, input);
        }
        else{
            throw new IllegalArgumentException("Invalid input: " + input+"\nValid inputs are: 1 - for action 1; 2 - for action 2");
        }
    }

    @Override
    public String getInformation() {
        return actions[0].getInformation() + " and " + actions[1].getInformation();
    }
}
