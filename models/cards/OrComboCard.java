package models.cards;

import models.Card;
import models.GameBoard;
import models.Player;
import views.UserInput;

public class OrComboCard implements Card {
    private Card[] actions;

    public OrComboCard(Card[] actions) {
        this.actions = actions;
    }

    @Override
    public void executeAction(Player player, GameBoard gameBoard, UserInput input) {
        // int userSelection = input.getSelection();   
        int userSelection = 1;                          // for testing purposes
        if(userSelection == 1){
            actions[0].executeAction(player, gameBoard, input);
        }
        else if(userSelection == 2){
            actions[1].executeAction(player, gameBoard, input);
        }
        else{
            throw new IllegalArgumentException("Invalid input: " + userSelection +"\nValid inputs are: 1 - for action 1; 2 - for action 2");
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
