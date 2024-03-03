package controllers;

import models.Card;
import models.GameBoard;
import models.Player;
import views.CardView;

public class CardController {
    private Card model;
    private CardView view;

    public CardController(Card card, CardView view){
        this.model = card;
        this.view = view;
    }

    public void updateView(){
        view.updateView(model);
    }

     public String getCardInformation(){
        return model.getInformation();
     }

    public void executeCardAction(Player player, GameBoard gameBoard){
        model.executeAction(player, gameBoard);
    }
}
