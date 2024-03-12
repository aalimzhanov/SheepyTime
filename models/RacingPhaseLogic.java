package models;

import controllers.DeckController;
import controllers.GameBoardController;
import controllers.PlayerController;
import views.UserInput;

/**
 * This class represents the logic for the racing phase of the game.
 * It contains methods for playing a racing move and checking fences.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class RacingPhaseLogic {

    /**
     * Plays a racing move for the player.
     * This method fills the player's hand with cards, resolves any nightmares,
     * allows the player to play a card, checks fences, and activates tiles if
     * necessary.
     *
     * @param playerController    the player controller
     * @param gameBoardController the game board controller
     * @param deckController      the deck controller
     * @param userInput           the user input
     */
    public void playRacingMove(PlayerController playerController, GameBoardController gameBoardController,
            DeckController deckController, UserInput userInput) {
        // Fill player hands
        while (playerController.needsACard()) {
            Card newCard = deckController.drawCard();
            if (newCard.isNightmare()) {
                newCard.executeAction(playerController.getModel(), gameBoardController.getModel(), userInput);
            } else {
                playerController.gainCard(newCard);
            }
            if (gameBoardController.isTurnOver()) {
                return;
            }
        }
        playerController.updateView();

        // For single player, if the top card is a nightmare, resolve it
        Card topCard = deckController.drawCard();
        if (topCard.isNightmare()) {
            topCard.executeAction(playerController.getModel(), gameBoardController.getModel(), userInput);
            if (gameBoardController.isTurnOver()) {
                return;
            }
        }

        gameBoardController.displayInformation();

        int cardIndex = userInput.getCardSelection();
        Card playedCard = playerController.playCard(cardIndex);
        playedCard.executeAction(playerController.getModel(), gameBoardController.getModel(), userInput);
        checkFence(gameBoardController, playerController.getModel(), userInput);
        if (gameBoardController.isTurnOver()) {
            return;
        }
        if (gameBoardController.isTilePlaced(gameBoardController.getMovablePosition(playerController.getModel()))) {
            boolean activateTile = userInput.getActivateTileDecision(
                    gameBoardController.getTile(gameBoardController.getMovablePosition(playerController.getModel()))
                            .getTileName());
            if (activateTile) {
                gameBoardController.getTile(gameBoardController.getMovablePosition(playerController.getModel()))
                        .activateTileEffect(playerController.getModel(),
                                gameBoardController.getModel(), userInput);
            }
        }

        // Draw a new card
        Card newCard = deckController.drawCard();
        while (newCard.isNightmare()) {
            newCard.executeAction(playerController.getModel(), gameBoardController.getModel(), userInput);
            newCard = deckController.drawCard();
            if (gameBoardController.isTurnOver()) {
                return;
            }
        }
        playerController.gainCard(newCard);
    }

    /**
     * Checks if the player has crossed a fence and prompts the user to call it a
     * night.
     * If the user chooses to call it a night, the game board is updated
     * accordingly.
     *
     * @param gameBoardController the game board controller
     * @param player              the player
     * @param userInput           the user input
     */
    private void checkFence(GameBoardController gameBoardController, Player player, UserInput userInput) {
        if (player.hasCrossedFence()) {
            boolean callItANight = userInput.getCallItANightDecision();
            if (callItANight) {
                gameBoardController.callItANight(player);
            }
            player.resetFence();
        }
    }
}
