package models.cards;

import models.Card;
import models.GameBoard;
import models.Player;
import views.UserInput;

public class GainWinksCard implements Card{
    private int winks;
    public GainWinksCard(int winks) {
        this.winks = winks;
    }
    @Override
    public void executeAction(Player player, GameBoard gameBoardm, UserInput input) {
        player.gainWinks(winks);
    }
    @Override
    public String getInformation() {
        if(winks == 1){
            return "Gain one wink";
        }
        return "Gain "+winks+" winks";
    }
    @Override
    public boolean isNightmare() {
        return false;
    }
}
