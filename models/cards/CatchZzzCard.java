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
        if(zzzs == 1){
            return "Catch 1 zzz";
        }
        return "Catch "+zzzs+" zzzs";
    }

    @Override
    public void executeAction(Player player, GameBoard gameBoard, UserInput input) {
        // Figure out the logic for tile placement
        player.catchZZZs(zzzs); 
    }

    @Override
    public boolean isNightmare() {
        return false;
    }
}
