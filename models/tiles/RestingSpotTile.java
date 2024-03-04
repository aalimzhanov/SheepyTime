package models.tiles;

import models.GameBoard;
import models.Player;
import models.Tile;
import views.UserInput;


public class RestingSpotTile extends Tile {

    public RestingSpotTile() {
        super("Resting Spot", "Catch 1 zzz. You may become BRAVE.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board, UserInput userInput) {
        
        if (playerInfiniteZZZs > 0 || playerZZZs > 0) {
            player.catchZZZs(1);
            if (player.isScared()) {
                player.becomeBrave();
            }
            if (playerInfiniteZZZs == 0) {
                playerZZZs--;
            }
        }
    }
}
