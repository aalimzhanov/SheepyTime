public class ScoreBoardController implements Controller{

    private ScoreBoard scoreBoard;
    private ScoreBoardView view;

    public ScoreBoardController(){
        // numOfPlayers to be added
        scoreBoard = new ScoreBoard(0);
        view = new ScoreBoardView();
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
