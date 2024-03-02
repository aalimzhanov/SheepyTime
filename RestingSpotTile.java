public class RestingSpotTile extends Tile {

    public RestingSpotTile() {
        super("Resting Spot", "Catch 1 zzz. You may become BRAVE.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        player.catchZZZs(1);
        if (player.isScared()) {
            player.becomeBrave();
        }
    }
}
