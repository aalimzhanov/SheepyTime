import controllers.GameController;
import controllers.PlayerController;
import models.Player;
import views.PlayerView;

public class PlayerFactory{
    public static void intialisePlayers(UserInput userInput, GameController gameController, int numOfPlayers) {
        for (int i = 0; i < numOfPlayers; i++){
            Player newPlayer = new Player(userInput.getPlayerName(), userInput.getSheepColor());
            PlayerView newView = new PlayerView();
            PlayerController controller = new PlayerController(newPlayer, newView);
            gameController.addPlayerController(controller);
        }
    }
}