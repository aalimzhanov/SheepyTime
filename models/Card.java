package models;

import views.UserInput;

public interface Card {
    public String getInformation();
    public void executeAction(Player player, GameBoard gameBoard, UserInput input);
    public boolean isNightmare();
}
