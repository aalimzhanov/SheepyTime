package views;
import tiles.Tile;

public class TileView {

    public void displayInfo(Tile tile) {
        System.out.println("Name: " + tile.getName());
        System.out.println("Ability: " + tile.getAbilityDescription());
        System.out.println("ZZZ Type: " + (tile.isInfinite()  ? "Infinite" : "Regular"));
        System.out.println("ZZZ Count: " + tile.getZzzCount());
    }
    
}
