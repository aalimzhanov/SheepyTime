package controllers;

import models.Card;
import models.GameBoard;
import models.Player;
import views.CardView;
import views.UserInput;

public class CardController {
    private Card model;
    private CardView view;
    private UserInput input;

    public CardController(Card card, CardView view, UserInput input){
        this.model = card;
        this.view = view;
        this.input = input;
    }

    public void updateView(){
        view.displayInformation(model);
    }

     public String getCardInformation(){
        return model.getInformation();
     }

    public void executeCardAction(Player player, GameBoard gameBoard){
        model.executeAction(player, gameBoard, input);
    }
}
