// package tests;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// import views.UserInput;


// public class UserInputTest {

//     @Test
//     public void testGetPlayerName_ValidInput_ReturnsName() {
//         UserInput userInput = new UserInput();

//         String name = userInput.getPlayerName();

//         assertEquals("Tan", name);
//     }

//     @Test
//     public void testGetPlayerName_EmptyInput_PromptsAndReturnsName() {
//         UserInput userInput = new UserInput();

//         String name = userInput.getPlayerName();

//         assertEquals("Tan", name);
//     }

//     @Test
//     public void testGetSheepColor_ValidInput_ReturnsColor() {
//         UserInput userInput = new UserInput();

//         String color = userInput.getSheepColor();

//         assertEquals("yellow", color);
//     }

//     @Test
//     public void testGetSheepColor_InvalidInput_PromptsAndReturnsColor() {
//         UserInput userInput = new UserInput();

//         String color = userInput.getSheepColor();

//         assertEquals("yellow", color);
//     }

//     @Test
//     public void testActivateTilePrompt_YesInput_ReturnsTrue() {
//         UserInput userInput = new UserInput();

//         boolean activate = userInput.activateTilePrompt();

//         assertTrue(activate);
//     }

//     @Test
//     public void testActivateTilePrompt_NoInput_ReturnsFalse() {
//         UserInput userInput = new UserInput();

//         boolean activate = userInput.activateTilePrompt();

//         assertFalse(activate);
//     }

//     @Test
//     public void testActivateTilePrompt_InvalidInput_PromptsAndReturnsValue() {
//         UserInput userInput = new UserInput();

//         boolean activate = userInput.activateTilePrompt();

//         assertTrue(activate);
//     }

// }
