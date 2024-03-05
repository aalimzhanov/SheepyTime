package models;

import controllers.DeckController;
import controllers.GameBoardController;
import controllers.PlayerController;
import views.UserInput;

public class RacingPhaseLogic {
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
                            .getAbilityDescription());
            if (activateTile) {
                gameBoardController.getTile(gameBoardController.getMovablePosition(playerController.getModel()))
                        .activateEffect(playerController.getModel(),
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
