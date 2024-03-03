package models.tiles;

import models.GameBoard;
import models.Player;
import models.Tile;

public class ActionHeroTile extends Tile {
    public ActionHeroTile() {
        super("Action Hero", "If you are SCARED, gain 3 winks", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        if (player.isScared()) {
            player.gainWinks(3);
        }
    }
}
