package views;

import models.ScoreBoard;

/**
 * This class represents the view for the scoreboard in the SheepyTime game.
 * It provides methods to display the scoreboard and show error messages.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class ScoreBoardView {

    /**
     * Displays the scoreboard with the current game state.
     *
     * @param scoreBoard the scoreboard object containing player scores and pillow positions
     */
    public void displayScoreBoard(ScoreBoard scoreBoard) {
        System.out.println("Current Game State:");
        System.out.println("Player\tScore\tPillow Position");
        scoreBoard.getPlayers().forEach(player -> {
            int score = scoreBoard.getWinks(player);
            int pillowPosition = scoreBoard.getPillowPosition(player);
            System.out.printf("%s\t%d\t%d%n", player.getName(), score, pillowPosition);
        });
    }

    /**
     * Displays an error message.
     *
     * @param message the error message to be displayed
     */
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
