package models;

import java.util.List;

import controllers.DeckController;
import controllers.GameBoardController;
import controllers.PlayerController;
import controllers.ScoreBoardController;
import views.GameView;
import views.UserInput;

public class GameLogic {
    public static void playGame(List<PlayerController> playerControllers, GameBoardController gameBoardController,
            DeckController deckController,
            ScoreBoardController scoreBoardController, GameView gameView, TileDeck tileDeck, UserInput userInput) {
        boolean gameEnded = false;
        while (!gameEnded) {
            for (PlayerController playerController : playerControllers) {
                // Add a boolean to show if it is the racing phase
                gameView.showPlayerTurn(playerController.getPlayerName(), true);
                takeTurn(gameBoardController, deckController, tileDeck, playerController, userInput, true);
                gameEnded = checkWinConditions(scoreBoardController);
                if (gameEnded) {
                    break;
                }
            }
            for (PlayerController playerController : playerControllers) {
                gameView.showPlayerTurn(playerController.getPlayerName(), false);
                takeTurn(gameBoardController, deckController, tileDeck, playerController, userInput, false);
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

    private static void takeTurn(GameBoardController gameBoardController, DeckController deckController,
            TileDeck tileDeck,
            PlayerController playerController, UserInput userInput, boolean isRacingPhase) {
        if (isRacingPhase) {
            // Need to modify this for multiplayer
            RacingPhaseLogic racingPhaseLogic = new RacingPhaseLogic();
            racingPhaseLogic.playRacingMove(playerController.getModel(), gameBoardController, deckController,
                    userInput);
            playerController.updateView();
        } else {
            RestingPhaseLogic restingPhaseLogic = new RestingPhaseLogic();
            restingPhaseLogic.playRestingMove(gameBoardController, userInput, tileDeck, playerController.getModel());
            playerController.updateView();
        }
    }
}
