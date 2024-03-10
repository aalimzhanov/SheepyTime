package views;

public class GameView {
    
    public void showWelcomeMessage() {
        System.out.println("\nWelcome to Sheepy Time! Prepare for an adventure in dreamland.");
    }

    public void showPlayerTurn(String playerName, boolean isRacingPhase) {
        String phase = isRacingPhase ? "racing" : "resting";
        System.out.println("It's " + playerName + "'s turn in the " + phase + " phase. Choose your action wisely.");
    }

    public void showWinner(String playerName) {
        System.out.println("Congratulations, " + playerName + "! You have won the game!");
    }

    public void showGameOver() {
        System.out.println("Thank you for playing. The game has now ended.");
    }
}
