public class LoneSheepTile extends Tile {

    public LoneSheepTile() {
        super("Lone Sheep", "If you have no zzzs on any other dream tiles within 2 spaces of this one, gain 3 winks.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        // boolean hasAdjacentZzzs = board.checkAdjacentTilesForZzzs(player, this); // How to check for zzzs on adjacent tiles
        boolean hasAdjacentZzzs = false; // For testing purposes
        if (!hasAdjacentZzzs) {
            player.gainWinks(3);
        }
    }
}
