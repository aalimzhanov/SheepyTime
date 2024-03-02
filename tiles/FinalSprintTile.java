package tiles;

import models.GameBoard;
import models.Player;

public class FinalSprintTile extends Tile {

    public FinalSprintTile() {
        super("Final Sprint", "If you are SCARED, move forward 7 spaces.", false, 3);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        if (player.isScared()) {
            board.moveMovable(player, 7);
        }
    }
}
