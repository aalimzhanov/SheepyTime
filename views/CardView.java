package views;

import models.Card;

/**
 * This class represents a CardView, which is responsible for displaying information of a Card.
 * 
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class CardView {
    
    /**
     * Displays the information of a Card.
     * 
     * @param model the Card object containing the information to be displayed
     */
    public void displayInformation(Card model){
        System.out.println(model.getInformation() );
    }
}
