package views;
/*
 * This class represents the view of a Nightmare
 */

import models.Nightmare;

public class NightmareView {

    public void updateView(Nightmare model) {
        System.out.println("Nightmare name: "+model.getName());
        System.out.println("Nightmare's description: "+model.getDescription());
        System.out.println("Nightmare's Difficulty "+model.getDifficulty());
    }
    
}
