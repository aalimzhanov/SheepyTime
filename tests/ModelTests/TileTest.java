package tests.ModelTests;
// package tests;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import models.Tile;

// import static org.junit.jupiter.api.Assertions.*;

// public class TileTest {

//     private Tile tile;

//     @BeforeEach
//     void setUp() {
//         // test each tile in the class
//         tile = new Tile("Test Tile", "Test Ability", false, 5);
//     }

//     @Test
//     void testGetName() {
//         assertEquals("Test Tile", tile.getName(), "The name should correctly be 'Test Tile'");
//     }

//     @Test
//     void testGetAbilityDescription() {
//         assertEquals("Test Ability", tile.getAbilityDescription(), "The ability description should correctly be 'Test Ability'");
//     }

//     @Test
//     void testIsInfinite() {
//         assertFalse(tile.isInfinite(), "isInfinite should be false");
//     }

//     @Test
//     void testGetZzzCount() {
//         assertEquals(5, tile.getZzzCount(), "The zzz count should correctly be 5");
//     }

//     @Test
//     void testPlaceZzzs() {
//         tile.placeZzzs(3, false);
//         assertEquals(3, tile.playerZZZs, "The playerZZZs count should correctly be 3");
        
//         tile.placeZzzs(2, true);
//         assertEquals(2, tile.playerInfiniteZZZs, "The playerInfiniteZZZs count should correctly be 2");
//     }

//     // TODO: Add test for activateEffect method

// }