package models;
public interface Card {
    public String getInformation();
    public void executeAction(Player player, GameBoard gameBoard);
}
