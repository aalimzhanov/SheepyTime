import java.util.List;

import controllers.*;
import factories.*;
import views.UserInput;
public class Main {
    public static void main(String[] args) {
        Coordinator coordinator = new Coordinator();
        UserInput userInput = new UserInput();
        initializePlayers(coordinator, userInput);
    }
    
    private static void initializePlayers(Coordinator coordinator, UserInput userInput) {
        int numOfPlayers = userInput.getNumOfPlayers();
        List<PlayerController> players = PlayerFactory.intialisePlayers(userInput, numOfPlayers);
        coordinator.addPlayerControllers(players);
    }
    
}
