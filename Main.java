import controllers.*;
import views.UserInput;
public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        int numOfPlayers = userInput.getNumOfPlayers();
        GameController gameController = new GameController(numOfPlayers, userInput);
        gameController.startGame();
    }

}