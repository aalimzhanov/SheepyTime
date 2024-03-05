import java.util.List;
import controllers.*;
import factories.*;
import views.UserInput;
public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        int numOfPlayers = userInput.getNumOfPlayers();
        GameController gameController = new GameController(numOfPlayers);
        gameController.startGame();
        initializePlayers(userInput, numOfPlayers);
    }

    private static void initializePlayers(UserInput userInput, int numOfPlayers) {
        List<PlayerController> players = PlayerFactory.intialisePlayers(userInput, numOfPlayers);
    }

}