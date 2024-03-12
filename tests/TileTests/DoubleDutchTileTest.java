package TileTests;

import models.GameBoard;
import models.Player;
import models.cards.MoveSpacesCard;
import models.tiles.DoubleDutchTile;
import views.UserInput;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleDutchTileTest {

    private Player playerWithInfiniteZZZs;
    private Player playerWith0ZZZs;
    private DoubleDutchTile doubleDutchTile;
    private GameBoard board; 
    private UserInput userInput;
    private MoveSpacesCard primaryCard, secondaryCard;

    @Before
    public void setUp() {
        doubleDutchTile = new DoubleDutchTile();
        board = new GameBoard(); 
        userInput = new UserInput(); 

        primaryCard = new MoveSpacesCard(3);
        secondaryCard = new MoveSpacesCard(2); 
        
        // player with infinite ZZZs
        playerWithInfiniteZZZs = new Player("player with infinite ZZZs", "red");
        playerWithInfiniteZZZs.gainCard(primaryCard);
        playerWithInfiniteZZZs.gainCard(secondaryCard);
        
        // player with 0 ZZZs
        playerWith0ZZZs = new Player("player with 0 ZZZs", "blue");
        playerWith0ZZZs.gainCard(primaryCard);
        playerWith0ZZZs.gainCard(secondaryCard);
    }

    @Test
    public void testActivateEffectWithInfiniteZZZs() {
        int initialPosition = playerWithInfiniteZZZs.getPillowPosition();
        
        doubleDutchTile.activateEffect(playerWithInfiniteZZZs, board, userInput);
        
        assertEquals("Player with infinite ZZZs should move by 2 spaces", initialPosition + secondaryCard.spaces, playerWithInfiniteZZZs.getPillowPosition());
    }

    @Test
    public void testActivateEffectDoesNotApplyWith0ZZZs() {
        int initialPosition = playerWith0ZZZs.getPillowPosition();
        
        doubleDutchTile.activateEffect(playerWith0ZZZs, board, userInput);
        
        assertEquals("Player's position should not change with 0 ZZZs", initialPosition, playerWith0ZZZs.getPillowPosition());
    }

}
