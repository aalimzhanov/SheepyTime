package controllers;

import models.Card;
import models.Deck;
import views.DeckView;

public class DeckController{
    private Deck deck;
    private DeckView view;
    public DeckController(){
        deck = new Deck();
        view = new DeckView();
        populateDeck();
    }
    public void populateDeck(){
        
    }
    public Deck getModel() {
        return deck;
    }
    public Card drawCard(){
        return deck.drawCard();
    }

}
