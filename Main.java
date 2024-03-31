import controllers.*;
import views.UserInput;
/**
 * The Main class is the entry point of the SheepyTime game.
 * It initializes the necessary objects and starts the game.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class Main {
    /**
     * The main method is the entry point of the program.
     * It creates an instance of UserInput, sets the number of players,
     * creates an instance of GameController, and starts the game.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        // For this milestone just 1 player
        // int numOfPlayers = userInput.getNumOfPlayers();
        int numOfPlayers = 1;
        GameController gameController = new GameController(numOfPlayers, userInput);
        gameController.startGame();
    }
}