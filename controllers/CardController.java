package controllers;

import models.Card;
import models.GameBoard;
import models.Player;
import views.CardView;
import views.UserInput;

/**
 * The CardController class represents a controller for a card in a game.
 * It manages the interaction between the card model, the card view, and user input.
 * 
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class CardController {
    private Card model;
    private CardView view;
    private UserInput input;

    /**
     * Constructs a CardController object with the specified card, view, and user input.
     * 
     * @param card  the card model
     * @param view  the card view
     * @param input the user input
     */
    public CardController(Card card, CardView view, UserInput input) {
        this.model = card;
        this.view = view;
        this.input = input;
    }

    /**
     * Updates the view to display the information of the card model.
     */
    public void updateView() {
        view.displayInformation(model);
    }

    /**
     * Retrieves the information of the card model.
     * 
     * @return the card information
     */
    public String getCardInformation() {
        return model.getInformation();
    }

    /**
     * Executes the action associated with the card for the given player on the game board.
     *
     * @param player The player who is executing the card action.
     * @param gameBoard The game board on which the action is being executed.
     */
    public void executeCardAction(Player player, GameBoard gameBoard) {
        model.executeAction(player, gameBoard, input);
    }
}
