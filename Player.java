import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private Sheep sheep;
    private List<ZZZToken> zzzs;
    private Card[] hand;
    public Player(String playerName, Color color){
        this.playerName = playerName;
        sheep = new Sheep(color, this);
        zzzs = new ArrayList<>();
        hand = new Card[2];
    }
    public ActionType makeARestingMove(){
        // temporary
        return ActionType.CALL_IT_A_NIGHT;
    }
    public Card makeARacingMove(){
        // temporary
        return hand[1];
    } 
    public void pickUpACard(Card newCard){
        // temporary
        hand[1] = newCard;
    }
    public Sheep getSheep(){
        return sheep;
    }
}
