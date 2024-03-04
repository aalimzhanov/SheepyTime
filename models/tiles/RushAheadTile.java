package models.tiles;

import models.Card;
import models.GameBoard;
import models.Player;
import models.Tile;
import models.cards.MoveSpacesCard;


public class RushAheadTile extends Tile {

    public RushAheadTile() {
        super("Rush Ahead", "Gain 1 wink. Play the top card of the deck.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        player.gainWinks(1);
        
        Card topCard = board.getDeck().drawTopCard();
        topCard.executeAction(player, board, userInput);
    }
}
