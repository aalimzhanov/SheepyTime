package models.cards;

import models.Card;
import models.GameBoard;
import models.Player;
import views.UserInput;

public class MoveSpacesCard implements Card {
    private int spaces;

    public MoveSpacesCard(int spaces) {
        this.spaces = spaces;
    }

    @Override
    public void executeAction(Player player, GameBoard gameBoard, UserInput input) {
        gameBoard.moveMovable(player, spaces);
    }

    @Override
    public String getInformation() {
        if(spaces == 1){
            return "Move one space";
        }
        return "Move "+spaces+" spaces";
    }

    @Override
    public boolean isNightmare() {
        return false;
    }
}