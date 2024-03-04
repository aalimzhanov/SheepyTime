package factories;

import controllers.NightmareController;
import models.BumpInTheNight;
import models.Nightmare;
import models.Spider;
import models.Wolf;
import views.NightmareView;
import views.UserInput;

public class NightmareFactory {
    public static NightmareController createNightmare(UserInput userInput) {
        int choice = userInput.getNightmareSelection();
        Nightmare nightmare;
        switch (choice) {
            case 1:
                nightmare = new Wolf();
                break;
            case 2:
                nightmare = new BumpInTheNight();
                break;
            case 3:
                nightmare = new Spider();
                break;
            default:
                nightmare = new Wolf();
                break;
        }
        NightmareView nightmareView = new NightmareView();
        NightmareController nightmareController = new NightmareController(nightmare, nightmareView);
        return nightmareController;
    }
}
