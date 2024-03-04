package views;

import models.ScoreBoard;

public class ScoreBoardView {

    public void displayScoreBoard(ScoreBoard scoreBoard) {
        System.out.println("Current Game State:");
        System.out.println("Player\tScore\tPillow Position");
        scoreBoard.getPlayers().forEach(player -> {
            int score = scoreBoard.getWinks(player);
            int pillowPosition = scoreBoard.getPillowPosition(player);
            System.out.printf("%s\t%d\t%d%n", player.getName(), score, pillowPosition);
        });
    }
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
