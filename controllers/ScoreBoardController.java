package controllers;

import java.util.List;

import models.ScoreBoard;
import views.ScoreBoardView;

public class ScoreBoardController {
    private ScoreBoard scoreBoard;
    private ScoreBoardView scoreBoardView;

    public ScoreBoardController(List<String> playerNames) {
        this.scoreBoard = new ScoreBoard(playerNames);
        this.scoreBoardView = new ScoreBoardView();
    }

    // Update the pillow position for a player
    public void movePillow(String playerName, int amount) {
        try {
            scoreBoard.movePillow(playerName, amount);
            updateView();
        } catch (IllegalArgumentException e) {
            scoreBoardView.showError(e.getMessage());
        }
    }

    // Update the winks for a player
    public void gainWinks(String playerName, int amount) {
        try {
            scoreBoard.gainWinks(playerName, amount);
            updateView();
        } catch (IllegalArgumentException e) {
            scoreBoardView.showError(e.getMessage());
        }
    }

    // Mark a player as having woken up
    public void wakeUp(String playerName) {
        try {
            scoreBoard.wakeUp(playerName);
            updateView();
        } catch (IllegalArgumentException e) {
            scoreBoardView.showError(e.getMessage());
        }
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

    // Display the current state of the scoreboard
    public void updateView() {
        scoreBoardView.displayScoreBoard(scoreBoard);
    }
}
