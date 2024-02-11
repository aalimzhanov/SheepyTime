public class GameBoardController implements Controller{

    private GameBoard board;
    private GameBoardView view;


    @Override
    public void initialize() {
        board = new GameBoard();
        view = new GameBoardView();    
    }

    @Override
    public void updateModel() {
        
    }

    @Override
    public void updateView() {
    
    }
    
}
