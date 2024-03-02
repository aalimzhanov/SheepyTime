public class NightmareController {

    Nightmare nightmare;
    NightmareView view;

    public NightmareController(){
        // Resolve picking a nightmare type
        nightmare = new BumpInTheNight();
        view = new NightmareView();
    }

    

}
