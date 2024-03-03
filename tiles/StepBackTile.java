package tiles;

import models.GameBoard;
import models.Player;

public class StepBackTile extends Tile {

    public StepBackTile() {
        super("Step Back", "Move backward 1 space. You may become BRAVE.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        // Move the player backward by 1 space. Assuming the GameBoard class has a method to handle this.
        board.moveMovable(player, -1);
        
        if (player.isScared()) {
            player.becomeBrave();
        }
    }
}
