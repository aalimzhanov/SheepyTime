package views;

import models.Card;

public class CardView {
    public void updateView(Card model){
        System.out.println("Card Info:"+ model.getInformation() );
    }
}
