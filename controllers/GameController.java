package controllers;
import views.UserInput;
import views.GameView;
import java.util.List;

import models.ScoreBoard;


public class GameController {
    private List<PlayerController> playerControllers;
    private GameBoardController gameBoardController;
    private NightmareController nightmareController;
    private Coordinator coordinator;
    private DeckController deckController;
    private ScoreBoardController scoreBoardController;
    private UserInput userInput;
    private GameView gameView;
    public GameController(List<PlayerController> playerControllers, NightmareController nightmareController) {
        this.playerControllers = playerControllers;
        this.nightmareController = nightmareController;
        initializeGame();
    }

    public void startGame() {
        gameView.showWelcomeMessage();
        playGame();
        concludeGame();
    }

    private void initializeGame() {
        // Add players and the nightmare to the game board
        this.gameBoardController = new GameBoardController();
        this.deckController = new DeckController();
        this.userInput = new UserInput();
        this.gameView = new GameView();
        List<String> playerNames = playerControllers.stream().map(pc -> pc.getPlayerName()).toList();
        scoreBoardController = new ScoreBoardController(playerNames);
        playerControllers.forEach(pc -> gameBoardController.addMovableToBoard(pc.getModel()));
        gameBoardController.addNightmareToBoard(nightmareController.getModel());
    }
    private void playGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            for (PlayerController playerController : playerControllers) {
                gameView.showPlayerTurn(playerController.getPlayerName());
                playerController.takeTurn(gameBoardController.getModel(), userInput);
                gameEnded = checkWinConditions();
                if (gameEnded) break;
            }
        }
    }
    private boolean checkWinConditions() {
        for (PlayerController pc : playerControllers) {
            if (pc.hasWon()) {
                gameView.showWinner(pc.getPlayerName());
                return true;
            }
        }
        return false;
    }
    private void concludeGame() {
        gameView.showGameOver();
    }
}
