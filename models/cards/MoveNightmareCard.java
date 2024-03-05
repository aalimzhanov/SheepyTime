package models.cards;

import models.Card;
import models.GameBoard;
import models.Player;
import views.UserInput;

public class MoveNightmareCard implements Card {
    private int spaces;

    public MoveNightmareCard(int spaces) {
        this.spaces = spaces;
    }

    @Override
    public void executeAction(Player player, GameBoard gameBoard, UserInput input) {
        gameBoard.moveNightmare(spaces);
    }

    @Override
    public String getInformation() {
        if (spaces < 0) {
            return "The nightmare moves " + spaces + " spaces backward.";
        }
        return "The nightmare moves " + spaces + " spaces forward.";
    }

    @Override
    public boolean isNightmare() {
        return true;
    }
}