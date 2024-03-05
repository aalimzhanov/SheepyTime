package controllers;

import views.UserInput;
import views.GameView;
import java.util.List;

import factories.DeckFactory;
import factories.GameBoardFactory;
import factories.NightmareFactory;
import factories.PlayerFactory;
import factories.ScoreBoardFactory;
import factories.TileDeckFactory;
import models.GameLogic;
import models.TileDeck;

public class GameController {
    private List<PlayerController> playerControllers;
    private GameBoardController gameBoardController;
    private NightmareController nightmareController;
    private DeckController deckController;
    private ScoreBoardController scoreBoardController;
    private UserInput userInput;
    private GameView gameView;
    private TileDeck tileDeck;

    public GameController(int numOfPlayers) {
        initializeGame(numOfPlayers);
    }

    public void startGame() {
        gameView.showWelcomeMessage();
        playGame();
        concludeGame();
    }

    private void initializeGame(int numOfPlayers) {
        userInput = new UserInput();
        gameView = new GameView();
        playerControllers = PlayerFactory.intialisePlayers(userInput, numOfPlayers);
        nightmareController = NightmareFactory.createNightmare(userInput);
        gameBoardController = GameBoardFactory.initializeGameBoard();
        deckController = DeckFactory.createDeck();
        scoreBoardController = ScoreBoardFactory.initializeScoreBoard(playerControllers);
        tileDeck = TileDeckFactory.createTiles();

        gameBoardController.addNightmareToBoard(nightmareController.getModel());

        for (PlayerController playerController : playerControllers) {
            gameBoardController.addMovableToBoard(playerController.getModel());
        }

    }

    private void playGame() {
        GameLogic.playGame(playerControllers, gameBoardController, deckController, scoreBoardController, gameView,
                tileDeck, userInput);
    }

    private void concludeGame() {
        gameView.showGameOver();
    }
}