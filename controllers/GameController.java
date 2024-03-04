package controllers;

import views.UserInput;
import views.GameView;
import java.util.List;

import factories.DeckFactory;
import factories.NightmareFactory;
import factories.PlayerFactory;
import factories.TileDeckFactory;
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
        gameBoardController = new GameBoardController();
        deckController = DeckFactory.createDeck();
        scoreBoardController = new ScoreBoardController(playerControllers);
        tileDeck = TileDeckFactory.createTiles();
        
        for (PlayerController playerController : playerControllers) {
            gameBoardController.addMovableToBoard(playerController.getModel());
        }
        
        gameBoardController.addNightmareToBoard(nightmareController.getModel());
    }

    private void playGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            for (PlayerController playerController : playerControllers) {
                gameView.showPlayerTurn(playerController.getPlayerName());
                playerController.takeTurn(gameBoardController, deckController, tileDeck, true);
                gameEnded = checkWinConditions();
                if (gameEnded) {
                    break;
                }
            }
        }
    }

    private boolean checkWinConditions() {
        return scoreBoardController.isGameOver();
    }

    private void concludeGame() {
        gameView.showGameOver();
    }
}
