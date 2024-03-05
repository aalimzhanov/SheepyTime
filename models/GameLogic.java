package models;

import java.util.List;

import controllers.DeckController;
import controllers.GameBoardController;
import controllers.PlayerController;
import controllers.ScoreBoardController;
import views.GameView;

public class GameLogic {
    public static void playGame(List<PlayerController> playerControllers, GameBoardController gameBoardController, DeckController deckController, ScoreBoardController scoreBoardController, GameView gameView, TileDeck tileDeck){
        boolean gameEnded = false;
        while (!gameEnded) {
            for (PlayerController playerController : playerControllers) {
                // Add a boolean to show if it is the racing phase
                gameView.showPlayerTurn(playerController.getPlayerName(), true);
                playerController.takeTurn(gameBoardController, deckController, tileDeck, true);
                gameEnded = checkWinConditions(scoreBoardController);
                if (gameEnded) {
                    break;
                }
            }
            for (PlayerController playerController : playerControllers) {
                gameView.showPlayerTurn(playerController.getPlayerName(), false);
                playerController.takeTurn(gameBoardController, deckController, tileDeck, false);
                gameEnded = checkWinConditions(scoreBoardController);
                if (gameEnded) {
                    break;
                }
            }
        }
    }
    private static boolean checkWinConditions(ScoreBoardController scoreBoardController) {
        return scoreBoardController.isGameOver();
    }
}
