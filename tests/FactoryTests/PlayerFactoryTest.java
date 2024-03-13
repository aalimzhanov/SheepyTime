package tests.FactoryTests;
import org.junit.jupiter.api.Test;

import controllers.PlayerController;
import factories.PlayerFactory;
import views.UserInput;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class PlayerFactoryTest {

    @Test
    public void testInitialisePlayers_ValidInput_ReturnsListOfPlayers() {
        String input = "Adil\nblue\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInput userInput = new UserInput();
        List<PlayerController> playerControllers = PlayerFactory.intialisePlayers(userInput, 1);

        assertEquals(1, playerControllers.size());
        assertEquals("Adil", playerControllers.get(0).getModel().getName());
        assertEquals("blue", playerControllers.get(0).getModel().getSheep().getColor());
    }

}