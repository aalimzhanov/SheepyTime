package views;

import models.Card;

public class CardView {
    public void displayInformation(Card model){
        System.out.println(model.getInformation() );
    }
}
