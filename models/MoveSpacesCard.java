package models;
public class MoveSpacesCard implements Card {
    private int spaces;

    public MoveSpacesCard(int spaces) {
        this.spaces = spaces;
    }

    @Override
    public void executeAction(Player player, GameBoard gameBoard) {
        gameBoard.moveMovable(player, spaces);
    }

    @Override
    public String getInformation() {
        if(spaces == 1){
            return "Move one space";
        }
        return "Move "+spaces+" spaces";
    }

    @Override
    public boolean isNightmare() {
        return false;
    }
}