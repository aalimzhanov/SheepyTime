package views;
import models.Tile;

public class TileView {

    public void displayInfo(Tile tile) {
        System.out.println("Tile name: "+ tile.getName());
        System.out.println("Tile ability: "+ tile.getAbilityDescription());
        System.out.println("Placement bonus: " + tile.getZzzCount() +(tile.isInfinite()  ? " infinite" : " regular") + " zzzs");
    }
    
}
