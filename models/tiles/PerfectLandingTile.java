package models.tiles;

import models.GameBoard;
import models.Player;
import models.Tile;
import views.UserInput;


public class PerfectLandingTile extends Tile {

    public PerfectLandingTile() {
        super("Perfect Landing", "If you crossed the fence this turn before landing here, gain winks equal to the space this is on.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board, UserInput userInput) {
        if (player.hasCrossedFenceThisTurn()) {
            if (playerInfiniteZZZs > 0 || playerZZZs > 0) {
                int currentSpace = board.getMovablePosition(player); 
                player.gainWinks(currentSpace);
                if (playerInfiniteZZZs == 0) {
                    playerZZZs--;
                }
            }    
        }
        
    }
}
