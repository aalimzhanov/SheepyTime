import java.util.ArrayList;
import java.util.List;

public class Tile {
    // String for now, potentially ActionType 
    private String actionType;
    private int actionValue;
    private List<ZZZToken> zzzs;

    public Tile(String actionType, int actionValue){
        this.actionType = actionType;
        this.actionValue = actionValue;
        zzzs = new ArrayList<>();
    }
    public String getActionType(){
        return actionType;
    }

    public int getActionValue(){
        return actionValue;
    }

    public void addToken(ZZZToken newToken){
        zzzs.add(newToken);
    }

    // Alternatively can remove items by getting a player as a parameter and matching a color of tokens and the player.
    public void useToken(ZZZToken useToken){
        zzzs.remove(useToken);
    }
}
