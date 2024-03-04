package models.tiles;

import models.Card;
import models.GameBoard;
import models.Player;
import models.Tile;
import views.UserInput;


public class DoubleDutchTile extends Tile {

    public DoubleDutchTile() {
        super("Double Dutch", "Play the other card from your hand.", false, 3);
    }

    @Override
    public void activateEffect(Player player, GameBoard board, UserInput userInput) {
       if (playerInfiniteZZZs > 0 || playerZZZs > 0) {
            Card otherCard = player.getOtherCardToPlay();
            otherCard.executeAction(player, board, userInput);
            if (playerInfiniteZZZs == 0) {
                playerZZZs--;
            }
        }
    }
}
