public class NightmareController implements Controller{

    Nightmare nightmare;
    NightmareView view;

    public NightmareController(){
        // Resolve picking a nightmare type
        nightmare = new BumpInTheNight();
        view = new NightmareView();
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void updateModel() {
        
    }

    @Override
    public void updateView() {
     
    }
    

}
