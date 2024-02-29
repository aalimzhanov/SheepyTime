public interface Card {
    public String getInformation();
    public void executeAction(PlayerController playerController, GameBoard gameBoard, UserInput input);
}
