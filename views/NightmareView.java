package views;
/*
 * This class represents the view of a Nightmare
 */

import models.Nightmare;

public class NightmareView {

    public void updateView(Nightmare model) {
        System.out.println("Nightmare: " + model.getName());
        System.out.println(model.getDescription());
        System.out.println("Difficulty level: " + model.getDifficulty());
    }

}
