package factories;

import controllers.DeckController;
import controllers.NightmareController;
import models.BumpInTheNight;
import models.Nightmare;
import models.Spider;
import models.Wolf;
import views.NightmareView;
import views.UserInput;

public class NightmareFactory {
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
            case 3:
                nightmare = new Spider();
                NightmareCardFactory.createNightmareCards(deckController.getModel(), "Spider");
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
