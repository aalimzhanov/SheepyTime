public class RushAheadTile extends Tile {

    public RushAheadTile() {
        super("Rush Ahead", "Gain 1 wink. Play the top card of the deck.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        player.gainWinks(1);
        
        // Card topCard = board.getDeck().drawTopCard(); // How do we draw the card?
        Card topCard = new MoveSpacesCard(1);   // Temporary card for testing
        topCard.executeAction(player, board);
    }
}
