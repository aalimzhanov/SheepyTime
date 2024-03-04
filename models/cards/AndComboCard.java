package models.cards;

import models.Card;
import models.GameBoard;
import models.Player;
import views.UserInput;

public class AndComboCard implements Card {
    private Card[] actions;

    public AndComboCard(Card[] actions) {
        this.actions = actions;
    }

    @Override
    public void executeAction(Player player, GameBoard gameBoard, UserInput input) {
        for (Card action : actions) {
            action.executeAction(player, gameBoard, input);
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
