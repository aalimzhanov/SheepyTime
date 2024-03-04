package models.cards;

import models.Card;
import models.GameBoard;
import models.Player;
import views.UserInput;

public class CatchZzzCard implements Card {
    private int zzzs;

    public CatchZzzCard(int zzzs) {
        this.zzzs = zzzs;
    }

    @Override
    public String getInformation() {
        return "Catch " + zzzs + (zzzs == 1 ? " zzz" : " zzzs");
    }

    @Override
    public void executeAction(Player player, GameBoard gameBoard, UserInput input) {
        // Figure out tile Logic for this
        // Should be in the player or the gameBoard?
        player.catchZZZs(zzzs);
    }

    @Override
    public boolean isNightmare() {
        return false;
    }
}
