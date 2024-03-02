package controllers;

import models.Deck;
import views.DeckView;

public class DeckController{
    private Deck deck;
    private DeckView view;
    public DeckController(){
        deck = new Deck();
        populateDeck();
        view = new DeckView();
    }
    public void populateDeck(){
        
    }
}
