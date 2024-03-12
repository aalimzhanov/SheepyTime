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

/**
 * The GameController class is responsible for controlling the game flow and managing the game components.
 * It initializes the game, starts the game, and concludes the game.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class GameController {
    private List<PlayerController> playerControllers;
    private GameBoardController gameBoardController;
    private NightmareController nightmareController;
    private DeckController deckController;
    private ScoreBoardController scoreBoardController;
    private UserInput userInput;
    private GameView gameView;
    private TileDeck tileDeck;

    /**
     * Constructs a GameController object with the specified number of players and user input.
     *
     * @param numOfPlayers The number of players in the game.
     * @param userInput    The user input object used for player interaction.
     */
    public GameController(int numOfPlayers, UserInput userInput) {
        initializeGame(numOfPlayers, userInput);
    }

    /**
     * Starts the game by displaying a welcome message, playing the game, and concluding the game.
     */
    public void startGame() {
        gameView.showWelcomeMessage();
        playGame();
        concludeGame();
    }

    /**
     * Initializes the game with the specified number of players and user input.
     *
     * @param numOfPlayers The number of players in the game.
     * @param userInput The user input object used for game interaction.
     */
    private void initializeGame(int numOfPlayers, UserInput userInput) {
        this.userInput = userInput;
        gameView = new GameView();
        playerControllers = PlayerFactory.intialisePlayers(userInput, numOfPlayers);
        gameBoardController = GameBoardFactory.initializeGameBoard();
        deckController = DeckFactory.createDeck();
        nightmareController = NightmareFactory.createNightmare(userInput, deckController);
        scoreBoardController = ScoreBoardFactory.initializeScoreBoard(playerControllers);
        tileDeck = TileDeckFactory.createTiles();

        gameBoardController.addNightmareToBoard(nightmareController.getModel());

        for (PlayerController playerController : playerControllers) {
            gameBoardController.addMovableToBoard(playerController.getModel());
        }
    }

    /**
     * Plays the game by invoking the necessary methods from various controllers and views.
     */
    private void playGame() {
        GameLogic.playGame(playerControllers, gameBoardController, deckController, scoreBoardController, gameView,
                tileDeck, userInput);
    }

    /**
     * Concludes the game by showing the game over screen.
     */
    private void concludeGame() {
        gameView.showGameOver();
    }
}