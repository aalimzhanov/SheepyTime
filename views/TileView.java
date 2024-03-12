package views;
import models.Tile;

/**
 * This class represents a view for Dream Tiles.
 * It provides methods to display information about a tile.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class TileView {

    /**
     * Displays information about the given tile.
     *
     * @param tile the tile to display information about
     */
    public void displayInfo(Tile tile) {
        System.out.println("Tile name: " + tile.getName());
        System.out.println("Tile ability: " + tile.getAbilityDescription());
        System.out.println("Placement bonus: " + tile.getZzzCount() + (tile.isInfinite() ? " infinite" : " regular") + " zzzs");
    }
    
}
