package tiles;

import models.GameBoard;
import models.Player;


public class IntenseDreamsTile extends Tile {

    public IntenseDreamsTile() {
        super("Intense Dreams", "Become SCARED to gain 4 winks.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        player.scareSheep();
        player.gainWinks(4);
    }
}
