package models.tiles;

import models.GameBoard;
import models.Player;
import models.Tile;
import views.UserInput;

public class IntenseDreamsTile extends Tile {

    public IntenseDreamsTile() {
        super("Intense Dreams", "Become SCARED to gain 4 winks.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board, UserInput userInput) {

        if (playerInfiniteZZZs > 0 || playerZZZs > 0) {
            player.becomeScared();
            player.gainWinks(4);
            if (playerInfiniteZZZs == 0) {
                playerZZZs--;
            }
        }
    }
}
