package models;

import views.UserInput;

public abstract class Tile {

    protected String name;
    protected String abilityDescription;
    protected boolean isInfinite;
    protected int zzzCount;
    protected int playerZZZs;
    protected int playerInfiniteZZZs;

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
        this.playerZZZs = 0;
        this.playerInfiniteZZZs = 0;
    }
    public void placeZzzs(int zzzs, boolean isInfinite) {
        if(isInfinite){
            playerInfiniteZZZs += zzzs;
        } else {
            playerZZZs += zzzs;
        }
    }

    public abstract void activateEffect(Player player, GameBoard board, UserInput userInput);

}
