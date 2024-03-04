package views;

public class GameView {
    
    public void showWelcomeMessage() {
        System.out.println("Welcome to Sheepy Time! Prepare for an adventure in dreamland.");
    }

    public void showPlayerTurn(String playerName) {
        System.out.println("It's " + playerName + "'s turn. Choose your action wisely.");
    }

    public void showWinner(String playerName) {
        System.out.println("Congratulations, " + playerName + "! You have won the game!");
    }

    public void showGameOver() {
        System.out.println("Thank you for playing. The game has now ended.");
    }

    public void showPlayerTurn(String name, boolean isRacingPhase) {
        if (isRacingPhase) {
            System.out.println("It's " + name + "'s turn in the racing phase. Choose your action wisely.");
        } else {
            System.out.println("It's " + name + "'s turn in the resting phase. Choose your action wisely.");
        }
    }
}
