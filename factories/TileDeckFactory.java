package factories;

import models.TileDeck;
import models.tiles.*;

public class TileDeckFactory {
    public static TileDeck createTiles() {
        TileDeck deck = new TileDeck();

        deck.addTile(new ActionHeroTile());
        deck.addTile(new CoolKidsClubTile());
        deck.addTile(new DoubleDutchTile());
        deck.addTile(new FinalSprintTile());
        deck.addTile(new IntenseDreamsTile());
        deck.addTile(new LoneSheepTile());
        deck.addTile(new PerfectLandingTile());
        deck.addTile(new RestingSpotTile());
        deck.addTile(new SecondWindTile());
        deck.addTile(new StepBackTile());
        return deck;
    }
}
