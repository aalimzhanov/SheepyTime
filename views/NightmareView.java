package views;
import models.Nightmare;

/**
 * This class represents the view for the Nightmare game mode.
 * It is responsible for updating and displaying the game view.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class NightmareView {

    /**
     * Updates the view with the given Nightmare model.
     * Prints the name, description, and difficulty level of the Nightmare.
     *
     * @param model The Nightmare model to update the view with.
     */
    public void updateView(Nightmare model) {
        System.out.println("Nightmare: " + model.getName());
        System.out.println(model.getDescription());
        System.out.println("Difficulty level: " + model.getDifficulty());
    }

}
