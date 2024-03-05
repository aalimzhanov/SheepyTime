package factories;

import controllers.GameBoardController;
import models.GameBoard;
import views.GameBoardView;

public class GameBoardFactory {
    public static GameBoardController initializeGameBoard(){
        GameBoard gameBoard = new GameBoard();
        GameBoardView gameBoardView = new GameBoardView();
        GameBoardController gameBoardController= new GameBoardController(gameBoard, gameBoardView);
        return gameBoardController;
    }
    
}
