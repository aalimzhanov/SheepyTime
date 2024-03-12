package models;

import java.util.List;

import controllers.DeckController;
import controllers.GameBoardController;
import controllers.PlayerController;
import controllers.ScoreBoardController;
import views.GameView;
import views.UserInput;

/**
 * This class represents the game logic for the SheepyTime game.
 * It contains methods for playing the game, checking win conditions, and taking
 * turns.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class GameLogic {

    /**
     * Plays the SheepyTime game.
     *
     * @param playerControllers    the list of player controllers
     * @param gameBoardController  the game board controller
     * @param deckController       the deck controller
     * @param scoreBoardController the score board controller
     * @param gameView             the game view
     * @param tileDeck             the tile deck
     * @param userInput            the user input
     */
    public static void playGame(List<PlayerController> playerControllers, GameBoardController gameBoardController,
            DeckController deckController,
            ScoreBoardController scoreBoardController, GameView gameView, TileDeck tileDeck, UserInput userInput) {
        boolean gameEnded = false;

        while (!gameEnded) {
            // Racing phase until everyone either woke up or called it a night
            while (!gameBoardController.isTurnOver()) {
                for (PlayerController playerController : playerControllers) {
                    gameView.showPlayerTurn(playerController.getPlayerName(), true);
                    takeTurn(gameBoardController, deckController, tileDeck, playerController, userInput, true);
                    gameEnded = checkWinConditions(scoreBoardController);
                    if (gameEnded) {
                        return;
                    }
                }
            }
            gameBoardController.resetPositions();
            scoreBoardController.endOfTurn();
            scoreBoardController.displayScoreBoard();
            // One turn per player for the resting phase
            for (PlayerController playerController : playerControllers) {
                gameView.showPlayerTurn(playerController.getPlayerName(), false);
                takeTurn(gameBoardController, deckController, tileDeck, playerController, userInput, false);
                gameEnded = checkWinConditions(scoreBoardController);
                if (gameEnded) {
                    return;
                }
            }
        }
    }

    /**
     * Checks if the win conditions for the game are met.
     *
     * @param scoreBoardController the score board controller
     * @return true if the win conditions are met, false otherwise
     */
    private static boolean checkWinConditions(ScoreBoardController scoreBoardController) {
        return scoreBoardController.isGameOver();
    }

    /**
     * Takes a turn in the game.
     *
     * @param gameBoardController the game board controller
     * @param deckController      the deck controller
     * @param tileDeck            the tile deck
     * @param playerController    the player controller
     * @param userInput           the user input
     * @param isRacingPhase       true if it is the racing phase, false if it is the
     *                            resting phase
     */
    private static void takeTurn(GameBoardController gameBoardController, DeckController deckController,
            TileDeck tileDeck,
            PlayerController playerController, UserInput userInput, boolean isRacingPhase) {
        if (isRacingPhase) {
            // Need to modify this for multiplayer
            RacingPhaseLogic racingPhaseLogic = new RacingPhaseLogic();
            racingPhaseLogic.playRacingMove(playerController, gameBoardController, deckController,
                    userInput);
        } else {
            RestingPhaseLogic restingPhaseLogic = new RestingPhaseLogic();
            restingPhaseLogic.playRestingMove(gameBoardController, userInput, tileDeck, playerController);
        }
    }
}
