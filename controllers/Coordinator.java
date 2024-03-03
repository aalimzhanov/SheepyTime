package controllers;
import factories.*;;
import java.util.ArrayList;
import java.util.List;


public class Coordinator {
    private DeckController deckController;
    private GameBoardController gameBoardController;
    private GameController gameController;
    private NightmareController nightmareController;
    private List<PlayerController> playerControllers;

    public Coordinator(){
        deckController = new DeckController();
        gameBoardController = new GameBoardController();
        gameController = new GameController();
        nightmareController = new NightmareController();
        playerControllers = new ArrayList<>();
    }
    public void addGameBoardController(GameBoardController gameBoardController){
        this.gameBoardController = gameBoardController;
    }
    public void addPlayerControllers(List<PlayerController> playerControllers){
        this.playerControllers = playerControllers;
    }

}
