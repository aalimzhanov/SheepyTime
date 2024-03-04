package models.tiles;

import models.Card;
import models.GameBoard;
import models.Player;
import models.Tile;
import models.cards.MoveSpacesCard;


public class DoubleDutchTile extends Tile {

    public DoubleDutchTile() {
        super("Double Dutch", "Play the other card from your hand.", false, 3);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        // Card otherCard = player.getOtherCardToPlay();
        Card otherCard = new MoveSpacesCard(2);   // Temporary card for testing
        otherCard.executeAction(player, board);
    }
}
