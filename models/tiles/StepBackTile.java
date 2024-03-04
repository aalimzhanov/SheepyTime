package models.tiles;

import models.GameBoard;
import models.Player;
import models.Tile;

public class StepBackTile extends Tile {

    public StepBackTile() {
        super("Step Back", "Move backward 1 space. You may become BRAVE.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        board.moveMovable(player, -1);
        
        if (player.isScared()) {
            player.becomeBrave();
        }
    }
}
