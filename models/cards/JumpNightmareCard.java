package models.cards;

import models.Card;
import models.GameBoard;
import models.Player;
import views.UserInput;

public class JumpNightmareCard implements Card {
    private int spaces;

    public JumpNightmareCard(int spaces) {
        this.spaces = spaces;
    }

    @Override
    public void executeAction(Player player, GameBoard gameBoard, UserInput input) {
        System.out.println("*Nightmare card was drawn*");
        System.out.println(getInformation());
        gameBoard.jumpNightmare(spaces);
    }

    @Override
    public String getInformation() {
        if (spaces < 0) {
            return "The nightmare jumps " + spaces + " spaces backward.";
        }
        return "The nightmare jumps " + spaces + " spaces forward.";
    }

    @Override
    public boolean isNightmare() {
        return true;
    }
}