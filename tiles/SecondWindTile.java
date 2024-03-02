package tiles;

import models.GameBoard;
import models.Player;

public class SecondWindTile extends Tile {

    public SecondWindTile() {
        super("Second Wind", "Discard your hand. You may become BRAVE.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        // Discard the player's hand. Assuming there's a method in Player to handle this.
        // player.discardHand();   // How do we discard the hand?
        
        if (player.isScared()) {
            player.becomeBrave();
        }
    }
}
