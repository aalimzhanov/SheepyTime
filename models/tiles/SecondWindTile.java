package models.tiles;

import models.GameBoard;
import models.Player;
import models.Tile;
import views.UserInput;

public class SecondWindTile extends Tile {

    public SecondWindTile() {
        super("Second Wind", "Discard your hand. You may become BRAVE.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board, UserInput userInput) {
        if (playerInfiniteZZZs > 0 || playerZZZs > 0) {
            player.discardHand();
            if (player.isScared()) {
                player.becomeBrave();
            }
            if (playerInfiniteZZZs == 0) {
                playerZZZs--;
            }
        }
        
    }
}
