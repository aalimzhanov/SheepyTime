package models.tiles;

import models.GameBoard;
import models.Player;
import models.Tile;
import views.UserInput;

public class StepBackTile extends Tile {

    public StepBackTile() {
        super("Step Back", "Move backward 1 space. You may become BRAVE.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board, UserInput userInput) {
        
        if (playerInfiniteZZZs > 0 || playerZZZs > 0) {
            board.moveMovable(player, -1);
            if (player.isScared()) {
                player.becomeBrave();
            }
            if (playerInfiniteZZZs == 0) {
                playerZZZs--;
            }
        }
    }
}
