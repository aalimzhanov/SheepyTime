package controllers;

import views.UserInput;
import views.GameView;
import java.util.List;

import factories.NightmareFactory;
import factories.PlayerFactory;
import models.Nightmare;


public class GameController {
    private List<PlayerController> playerControllers;
    private GameBoardController gameBoardController;
    private NightmareController nightmareController;
    private Coordinator coordinator;
    private DeckController deckController;
    private ScoreBoardController scoreBoardController;
    private UserInput userInput;
    private GameView gameView;

    public GameController(int numOfPlayers) {
        initializeGame(numOfPlayers);
    }

    public void startGame() {
        gameView.showWelcomeMessage();
        playGame();
        concludeGame();
    }

    private void initializeGame(int numOfPlayers) {
        // Add players and the nightmare to the game board
        this.playerControllers = PlayerFactory.intialisePlayers(userInput, numOfPlayers);
        this.nightmareController = NightmareFactory.createNightmare(userInput);
        this.gameBoardController = new GameBoardController();
        this.deckController = new DeckController();
        this.userInput = new UserInput();
        this.gameView = new GameView();
        this.scoreBoardController = new ScoreBoardController(playerControllers);
        playerControllers.forEach(pc -> gameBoardController.addMovableToBoard(pc.getModel()));
        gameBoardController.addNightmareToBoard(nightmareController.getModel());
    }

    private void playGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            for (PlayerController playerController : playerControllers) {
                gameView.showPlayerTurn(playerController.getPlayerName());

                // figure out phases
                playerController.takeTurn(gameBoardController, deckController, true);
                gameEnded = checkWinConditions();
                if (gameEnded)
                    break;
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
