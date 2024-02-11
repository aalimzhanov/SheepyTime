import java.util.LinkedList;
import java.util.Queue;

public class PlayerController implements Controller{

    private Queue<Player> players;
    private PlayerView view;


    public PlayerController(){
        players = new LinkedList<>();
        view = new PlayerView();
    }

    @Override
    public void initialize() {

    }

    @Override
    public void updateModel() {
    
    }

    @Override
    public void updateView() {
        view.update();
    }

    public void addPlayer(Player newPlayer){
        if(players.size()<=4){
            players.offer(newPlayer);
        }
        else{
            throw new IllegalStateException("Players limit(4) is reached");
        }
    }
    public void removePlayer(Player playerToRemove){
        boolean playerFound = false;
        Queue<Player> tempQueue = new LinkedList<>();
        while(!players.isEmpty()){
            Player tempPlayer = players.poll();
            if(tempPlayer.equals(playerToRemove)){
                playerFound = true;
            }
            else{
                tempQueue.offer(tempPlayer);
            }
        }
        while(!tempQueue.isEmpty()){
            players.offer(tempQueue.poll());
        }
        if(!playerFound){
            throw new IllegalArgumentException("Player not found");
        }
        updateView();
    }
    public Card playARacingMove(){
        Player activePlayer = players.poll();
        Card playedCard = activePlayer.makeARacingMove();
        // How does a player get a new card?
        activePlayer.pickUpACard(null);
        players.offer(activePlayer);
        updateView();
        return playedCard;
    }

    public ActionType playARestingMove(){
        Player activePlayer = players.poll();
        ActionType playedAction = activePlayer.makeARestingMove();
        players.offer(activePlayer);
        updateView();
        return playedAction;
    }
}
