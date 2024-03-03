package models.tiles;
import models.GameBoard;
import models.Player;
import models.Tile;

public class CoolKidsClubTile extends Tile {

    public CoolKidsClubTile() {
        super("Cool Kids Club", "Move your pillow down 1.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        // player.movePillow(-1);
    }
}
