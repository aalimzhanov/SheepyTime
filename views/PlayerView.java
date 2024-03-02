package views;
import models.Player;

public class PlayerView {
    
    public void updateView(Player player) {
        System.out.println("Player name: "+player.getName());
        System.out.println("Sheep color: "+player.getSheep().getColor());
        System.out.println("Player's first card: "+player.getCard(0).getInformation());
        System.out.println("Player's second card: "+player.getCard(1).getInformation());
        System.out.println("Player has "+player.getNumOfZzzs()+" zzzs");
    }
}
