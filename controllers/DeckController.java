package controllers;

import models.Card;
import models.Deck;

public class DeckController{
    private Deck deck;
    public DeckController(Deck deck){
        this.deck = deck;
    }
    public Deck getModel() {
        return deck;
    }
    public Card drawCard(){
        return deck.drawCard();
    }
}
