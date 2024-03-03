package controllers;

import models.GameBoard;
import views.GameBoardView;

public class GameBoardController {

    private GameBoard board;
    private GameBoardView view;

    public GameBoardController(GameBoard board, GameBoardView view){
        this.board = board;
        this.view = view;
    }
    
}
