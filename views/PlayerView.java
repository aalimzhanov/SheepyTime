package views;
import models.Player;

/**
 * This class represents the view for a player in the SheepyTime game.
 * It is responsible for updating the view with the player's information and displaying any errors that occur.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class PlayerView {
    
    /**
     * Updates the view with the player's information.
     * Prints the player's name, the color of their sheep, whether their sheep is scared or not,
     * the information of their first and second card (if available), and the number of zzzs they have.
     *
     * @param player the player whose information needs to be displayed
     */
    public void updateView(Player player) {
        System.out.println("Player: " + player.getName());
        System.out.println("Sheep: " + player.getSheep().getColor());
        System.out.println("Player's sheep is " + (player.isScared() ? "scared" : "not scared"));
        if (player.getCard(0) != null) {
            System.out.println("First card: " + player.getCard(0).getInformation());
        }
        if (player.getCard(1) != null) {
            System.out.println("Second card: " + player.getCard(1).getInformation());
        }
        System.out.println("Player has " + player.getNumOfZzzs() + " zzzs");
    }

    /**
     * Displays an error message.
     *
     * @param message the error message to be displayed
     */
    public void showError(String message) {
        System.err.println("Error: " + message);
    }
}
