public class CatchZzzCard implements Card {
    private int zzzs;

    public CatchZzzCard(int zzzs) {
        this.zzzs = zzzs;
    }


    @Override
    public String getInformation() {
        if(zzzs == 1){
            return "Catch 1 zzz";
        }
        return "Catch "+zzzs+" zzzs";
    }

    @Override
    public void executeAction(PlayerController playerController, GameBoard gameBoard, UserInput input) {
        // Figure out the logic for tile placement
        playerController.catchZZZs(zzzs); 
    }
}
