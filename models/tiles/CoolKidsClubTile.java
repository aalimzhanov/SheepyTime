package models.tiles;
import models.GameBoard;
import models.Player;
import models.Tile;
import views.UserInput;

public class CoolKidsClubTile extends Tile {

    public CoolKidsClubTile() {
        super("Cool Kids Club", "Move your pillow down 1.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board, UserInput userInput) {
        if (playerInfiniteZZZs > 0 || playerZZZs > 0) {
            player.movePillow(-1);
            if (playerInfiniteZZZs == 0) {
                playerZZZs--;
            }
        }
    }
}
