package tiles;

import models.GameBoard;
import models.Player;

public abstract class Tile {
    protected String name;
    protected String abilityDescription;
    protected boolean isInfinite;
    protected int zzzCount;

    public Tile(String name, String abilityDescription, boolean isInfinite, int zzzCount) {
        this.name = name;
        this.abilityDescription = abilityDescription;
        this.isInfinite = isInfinite;
        this.zzzCount = zzzCount;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Ability: " + abilityDescription);
        System.out.println("ZZZ Type: " + (isInfinite  ? "Infinite" : "Regular"));
        System.out.println("ZZZ Count: " + zzzCount);
    }

    public abstract void activateEffect(Player player, GameBoard board);

}
