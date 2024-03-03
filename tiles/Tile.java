package tiles;

import models.GameBoard;
import models.Player;

public abstract class Tile {
    
    protected String name;
    protected String abilityDescription;
    protected boolean isInfinite;
    protected int zzzCount;

    public int getZzzCount() {
        return zzzCount;
    }
    public String getName() {
        return name;
    }
    public String getAbilityDescription() {
        return abilityDescription;
    }
    public boolean isInfinite() {
        return isInfinite;
    }

    public Tile(String name, String abilityDescription, boolean isInfinite, int zzzCount) {
        this.name = name;
        this.abilityDescription = abilityDescription;
        this.isInfinite = isInfinite;
        this.zzzCount = zzzCount;
    }

    public abstract void activateEffect(Player player, GameBoard board);

}
