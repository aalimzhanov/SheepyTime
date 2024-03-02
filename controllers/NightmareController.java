package controllers;

import models.Nightmare;
import views.NightmareView;

public class NightmareController {

    Nightmare model;
    NightmareView view;

    public NightmareController(Nightmare model, NightmareView view){
        // Resolve picking a nightmare type
        this.model = model;
        this.view = view;
    }

    public void updateView(){
        view.updateView(model);
    }
    
    public String getNighmareName(){
        return model.getName();
    }
    public String getNightmareDescription(){
        return model.getDescription();
    }
    public int getNightmareDifficulty(){
        return model.getDifficulty();
    }
}
