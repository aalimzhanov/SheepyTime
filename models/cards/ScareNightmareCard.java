package models.cards;

import models.Card;
import models.GameBoard;
import models.Player;
import views.UserInput;

public class ScareNightmareCard implements Card {

    @Override
    public void executeAction(Player player, GameBoard gameBoard, UserInput input) {
        int position = gameBoard.getNightmarePos();
        for (int i = position; i <= position+1; i++) {
            // can't scare over the fence
            if(i >=0 && i <= 10){
                gameBoard.scareMovablesAtPosition(i);
            }
        }
    }

    @Override
    public String getInformation() {
        return "The nightmare scares all sheep on it space and adjacent spaces.";
    }

    @Override
    public boolean isNightmare() {
        return true;
    }
}