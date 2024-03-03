package controllers;

import models.Player;
import models.Sheep;
import models.Card;
import views.PlayerView;
import views.UserInput;

public class PlayerController {
    private Player model;
    private PlayerView view;
    private UserInput userInput;

    public PlayerController(Player model, PlayerView view, UserInput userInput) {
        this.model = model;
        this.view = view;
        this.userInput = userInput;
    }

    public void updateView() {
        view.updateView(model);
    }

    public String getPlayerName() {
        return model.getName();
    }

    public Sheep getSheep() {
        return model.getSheep();
    }

    public int getNumOfZzzs() {
        return model.getNumOfZzzs();
    }

    public void gainCard(DeckController deckController) {
        model.gainCard(deckController.drawCard());
        updateView();
    }

    public Card playCard(int index) {
        Card card = model.playCard(index);
        updateView();
        return card;
    }

    public void catchZZZs(int amount) {
        model.catchZZZs(amount);
        updateView();
    }

    public void takeTurn(GameBoardController gameBoardController, DeckController deckController,
            boolean isRacingPhase) {
        if (isRacingPhase) {
            // Need to modify this for multiplayer
            Card topCard = deckController.drawCard();
            // Find a way to determine if that is a Nightmare card
            if (topCard.isNightmare()) {
                topCard.executeAction(model, gameBoardController.getModel());
            }

            int cardIndex = userInput.getCardSelection();
            Card playedCard = model.playCard(cardIndex);
            playedCard.executeAction(model, gameBoardController.getModel());
            checkFence(gameBoardController);
            // Draw a new card
            Card newCard = deckController.drawCard();
            while (newCard.isNightmare()) {
                newCard.executeAction(model, gameBoardController.getModel());
                newCard = deckController.drawCard();
            }
            model.gainCard(newCard);
            view.updateView(model);
        }
    }

    public void checkFence(GameBoardController gameBoardController) {
        if (model.hasCrossedFence()) {
            boolean callItANight = userInput.getCallItANightDecision(); // Assuming this method exists
            if (callItANight) {
                gameBoardController.callItANight(model);
            }
            model.resetFence();
        }
    }

    /**
     * @return the model
     */
    public Player getModel() {
        return model;
    }
}
