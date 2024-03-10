package factories;

import controllers.TileController;
import models.TileDeck;
import models.tiles.*;
import views.TileView;

public class TileDeckFactory {
    public static TileDeck createTiles() {
        TileDeck deck = new TileDeck();

        deck.addTile(new TileController(new ActionHeroTile(), new TileView()));
        deck.addTile(new TileController(new CoolKidsClubTile(), new TileView()));
        deck.addTile(new TileController(new DoubleDutchTile(), new TileView()));
        deck.addTile(new TileController(new FinalSprintTile(), new TileView()));
        deck.addTile(new TileController(new IntenseDreamsTile(), new TileView()));
        deck.addTile(new TileController(new LoneSheepTile(), new TileView()));
        deck.addTile(new TileController(new PerfectLandingTile(), new TileView()));
        deck.addTile(new TileController(new RestingSpotTile(), new TileView()));
        deck.addTile(new TileController(new SecondWindTile(), new TileView()));
        deck.addTile(new TileController(new StepBackTile(), new TileView()));
        deck.initializeMarket();
        return deck;
    }
}
