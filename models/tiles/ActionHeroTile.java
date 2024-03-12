package models.tiles;

import models.GameBoard;
import models.Player;
import models.Tile;
import views.UserInput;

public class ActionHeroTile extends Tile {
    public ActionHeroTile() {
        super("Action Hero", "If you are SCARED, gain 3 winks", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board, UserInput userInput) {
        if (player.isScared()) {
            if (playerInfiniteZZZs > 0 || playerZZZs > 0) {
                player.gainWinks(3);
                if (playerInfiniteZZZs == 0) {
                    playerZZZs--;
                }
            }
            
        }
        
    }
}