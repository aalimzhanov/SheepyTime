public class MoveSpacesCard implements Card {
    private int spaces;

    public MoveSpacesCard(int spaces) {
        this.spaces = spaces;
    }

    @Override
    public void executeAction(PlayerController playerController, GameBoard gameBoard, UserInput input) {
        gameBoard.moveMovable(playerController.getModel(), spaces);
    }

    @Override
    public String getInformation() {
        if(spaces == 1){
            return "Move one space";
        }
        return "Move "+spaces+" spaces";
    }

}