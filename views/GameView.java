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

    // Any one action performed can be printed through this class, and then display updated version of other classes

}
