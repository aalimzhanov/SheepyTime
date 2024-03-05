package controllers;

import models.Player;
import models.RacingPhaseLogic;
import models.RestingPhaseLogic;
import models.Sheep;
import models.TileDeck;
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

    public int catchZZZs(int amount) {
        int zzzs = model.catchZZZs(amount);
        updateView();
        return zzzs;
    }

    public Player getModel() {
        return model;
    }
}
