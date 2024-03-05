package controllers;

import models.Player;
import models.ScoreBoard;
import views.ScoreBoardView;

public class ScoreBoardController {
    private ScoreBoard scoreBoard;
    private ScoreBoardView scoreBoardView;

    public ScoreBoardController(ScoreBoard scoreBoard, ScoreBoardView scoreBoardView) {
        this.scoreBoard = scoreBoard;
        this.scoreBoardView = scoreBoardView;
    }

    // Update the pillow position for a player
    public void movePillow(Player player, int amount) {
        scoreBoard.movePillow(player, amount);
        updateView();
    }

    // Update the winks for a player
    public void gainWinks(Player player, int amount) {
        scoreBoard.gainWinks(player, amount);
        updateView();
    }

    // Mark a player as having woken up
    public void wakeUp(Player player) {
        scoreBoard.wakeUp(player);
        updateView();
    }

    public void endOfTurn() {
        scoreBoard.endOfTurn();
        updateView();
    }

    public boolean isGameOver() {
        return scoreBoard.isGameOver();
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void updateView() {
        scoreBoardView.displayScoreBoard(scoreBoard);
    }
}
