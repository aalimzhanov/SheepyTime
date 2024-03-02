public class PerfectLandingTile extends Tile {

    public PerfectLandingTile() {
        super("Perfect Landing", "If you crossed the fence this turn before landing here, gain winks equal to the space this is on.", true, 1);
    }

    @Override
    public void activateEffect(Player player, GameBoard board) {
        // if (player.hasCrossedFenceThisTurn()) {  
        //     int currentSpace = player.getCurrentSpace(); 
        //     player.gainWinks(currentSpace);  
        // }
    }
}
