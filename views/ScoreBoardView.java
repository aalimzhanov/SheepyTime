package views;

import models.ScoreBoard;

public class ScoreBoardView {

    public void displayScoreBoard(ScoreBoard scoreBoard) {
        System.out.println("Current Game State:");
        System.out.println("Player\tScore\tPillow Position");
        scoreBoard.getPlayerNames().forEach(player -> {
            int score = scoreBoard.getScore(player);
            int pillowPosition = scoreBoard.getPillowPosition(player);
            System.out.printf("%s\t%d\t%d%n", player, score, pillowPosition);
        });
    }
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
