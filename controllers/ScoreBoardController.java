package controllers;

import java.util.List;
import java.util.stream.Collectors;

import models.Player;
import models.ScoreBoard;
import views.ScoreBoardView;

public class ScoreBoardController {
    private ScoreBoard scoreBoard;
    private ScoreBoardView scoreBoardView;

    public ScoreBoardController(List<PlayerController> playerControllers) {
        List<Player> players = playerControllers.stream().map(PlayerController::getModel).collect(Collectors.toList());
        this.scoreBoard = new ScoreBoard(players);
        this.scoreBoardView = new ScoreBoardView();
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
