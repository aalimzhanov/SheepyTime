package controllers;
/*
 * This class is responsible for creating all the controllers, 
 * initializing them and handling interaction between them.
 */

public class Coordinator {
    private DeckController deckController;
    private GameBoardController gameBoardController;
    private GameController gameController;
    private InitialController initialController;
    private NightmareController nightmareController;
    private PlayerController playerController;

    public Coordinator(){
        deckController = new DeckController();
        gameBoardController = new GameBoardController();
        gameController = new GameController();
        initialController = new InitialController();
        nightmareController = new NightmareController();
        playerController = new PlayerController(null, null);
    }

}
