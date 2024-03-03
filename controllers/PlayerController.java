package controllers;

import models.Card;
import models.Player;
import models.Sheep;
import views.PlayerView;

public class PlayerController {
    private Player model;
    private PlayerView view;
    public PlayerController(Player model, PlayerView view) {
        this.model = model;
        this.view = view;
    }
    public void updateView(){
        view.updateView(model);
    }
    public String getPlayerName() {
        return model.getName();
    }
    public Sheep getSheep() {
        return model.getSheep();
    }
    public Card getCard(int index) {
        return model.getCard(index);
    }
    public int getNumOfZzzs() {
        return model.getNumOfZzzs();
    }
    public void pickUpCard(int index, Card card) {
        model.pickUpCard(index, card);
        updateView();
    }
    public Card playCard(int index) {
        Card card = model.playCard(index);
        updateView();
        return card;
    }
    public void catchZZZs(int amount){
        model.catchZZZs(amount);
        updateView();
    }
    /**
     * @return the model
     */
    public Player getModel() {
        return model;
    }
}
