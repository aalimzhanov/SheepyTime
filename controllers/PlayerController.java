package controllers;

import models.Player;
import models.Sheep;
import models.Card;
import views.PlayerView;

public class PlayerController {
    private Player model;
    private PlayerView view;

    public PlayerController(Player model, PlayerView view) {
        this.model = model;
        this.view = view;
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

    public void gainCard(Card card) {
        model.gainCard(card);
    }
    public boolean needsACard() {
        return model.needsACard();
    }
    public Card playCard(int index) {
        Card card = model.playCard(index);
        return card;
    }

    public int catchZZZs(int amount) {
        int zzzs = model.catchZZZs(amount);
        return zzzs;
    }

    public Player getModel() {
        return model;
    }
}
