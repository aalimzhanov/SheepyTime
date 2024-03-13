package factories;

import controllers.DeckController;
import controllers.NightmareController;
import models.BumpInTheNight;
import models.Nightmare;
import models.Wolf;
import views.NightmareView;
import views.UserInput;

/**
 * The NightmareFactory class is responsible for creating NightmareController objects based on user input.
 * It provides a static method to create a NightmareController object with the specified Nightmare and DeckController.
 * 
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class NightmareFactory {

    /**
     * Creates a NightmareController object based on the user's Nightmare selection.
     * 
     * @param userInput The UserInput object containing the user's input.
     * @param deckController The DeckController object to create Nightmare cards.
     * @return A NightmareController object with the specified Nightmare and NightmareView.
     */
    public static NightmareController createNightmare(UserInput userInput, DeckController deckController) {
        int choice = userInput.getNightmareSelection();
        Nightmare nightmare;
        switch (choice) {
            case 1:
                nightmare = new Wolf();
                NightmareCardFactory.createNightmareCards(deckController.getModel(), "Wolf");
                break;
            case 2:
                nightmare = new BumpInTheNight();
                NightmareCardFactory.createNightmareCards(deckController.getModel(), "BumpInTheNight");
                break;
            default:
                nightmare = new Wolf();
                NightmareCardFactory.createNightmareCards(deckController.getModel(), "Wolf");
                break;
        }

        NightmareView nightmareView = new NightmareView();
        return new NightmareController(nightmare, nightmareView);
    }
}
