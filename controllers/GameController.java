package controllers;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    List<PlayerController> playerControllers;
    public GameController() {
        playerControllers = new ArrayList<>();
    }
    public void addPlayerController(PlayerController newController) {
        playerControllers.add(newController);
    }

}
