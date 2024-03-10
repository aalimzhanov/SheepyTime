package views;
import models.Player;

public class PlayerView {
    
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

    public void showError(String message) {
        System.err.println("Error: " + message);
    }
}
