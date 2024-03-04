package models;

import controllers.DeckController;
import controllers.GameBoardController;
import views.UserInput;

public class RacingPhaseLogic {
    public void playRacingMove(Player player, GameBoardController gameBoardController, DeckController deckController,
            UserInput userInput) {
        Card topCard = deckController.drawCard();
        if (topCard.isNightmare()) {
            topCard.executeAction(player, gameBoardController.getModel(), userInput);
        }

        int cardIndex = userInput.getCardSelection();
        Card playedCard = player.playCard(cardIndex);
        playedCard.executeAction(player, gameBoardController.getModel(), userInput);
        checkFence(gameBoardController, player, userInput);
        if (gameBoardController.isTilePlaced(gameBoardController.getMovablePosition(player))) {
            boolean activateTile = userInput.getActivateTileDecision(gameBoardController
                    .getTile(gameBoardController.getMovablePosition(player)).getAbilityDescription());
            if (activateTile) {
                gameBoardController.getTile(gameBoardController.getMovablePosition(player)).activateEffect(player,
                        gameBoardController.getModel(), userInput);
            }
        }
        // Draw a new card
        Card newCard = deckController.drawCard();
        while (newCard.isNightmare()) {
            newCard.executeAction(player, gameBoardController.getModel(), userInput);
            newCard = deckController.drawCard();
        }
        player.gainCard(newCard);
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
