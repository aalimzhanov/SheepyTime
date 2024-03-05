package factories;
import controllers.PlayerController;
import models.Player;
import views.PlayerView;
import views.UserInput;

import java.util.ArrayList;
import java.util.List;


public class PlayerFactory{
    public static List<PlayerController> intialisePlayers(UserInput userInput, int numOfPlayers) {
        List<PlayerController> playerControllers = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++){
            Player newPlayer = new Player(userInput.getPlayerName(), userInput.getSheepColor(), userInput.getSleepTime());
            PlayerView newView = new PlayerView();
            PlayerController controller = new PlayerController(newPlayer, newView);
            playerControllers.add(controller);
        }
        return playerControllers;
    }
}