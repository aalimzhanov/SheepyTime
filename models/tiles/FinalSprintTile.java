package models.tiles;

import models.GameBoard;
import models.Player;
import models.Tile;
import views.UserInput;

public class FinalSprintTile extends Tile {

    public FinalSprintTile() {
        super("Final Sprint", "If you are SCARED, move forward 7 spaces.", false, 3);
    }

    @Override
    public void activateEffect(Player player, GameBoard board, UserInput userInput) {
        if (player.isScared()) {
            if (playerInfiniteZZZs > 0 || playerZZZs > 0) {
                board.moveMovable(player, 7);
                if (playerInfiniteZZZs == 0) {
                    playerZZZs--;
                }
            }
            
        }
    }
}
