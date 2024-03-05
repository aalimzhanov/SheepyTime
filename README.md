# SheepyTime

A draft of Sheepy Time game

## Do NOT commit anything to the main branch!!!

## Completed classes:

`ActionHeroTile`, `AndComboCard`, `Card`, `CatchZzzCard`, `Deck`, `FinalSprintTile`, `IntenseDreamsTile`, `MoveSpacesCard`, `RestingSpotTile`, `Tile`

## Unfinished:

`CoolKidsClubTile`, `DoubleDutchTile`, `GameBoard`, `LoneSheepTile`,
`OrComboCard`, `PerfectLandingTile`, `RushAheadTile`, `SecondWindTile`, 

## Changes I made
The main changes was organizing the classes into packages. This made it easier to detect MVC violations.

This how you detect that: 
1. Every Controller should import its own model and view.
2. Every view should import only its corresponding model.
3. A model should not import a view or controller under no circumstances.

We should have a class (or this can be made in the main class) which initializes the game and all of the game environment. This class should be outside the packages.

Reworked the Nightmare controller and Nightmare view to adhere to MVC

Reworked the Gameboard controller and Gameboard view to adhere to MVC

Removed view interface because we do not need it

Created a Coordinator class which creates and initializes all the controllers and handles the interaction between them. (We can create Coordinator classes for specific controllers that need to interact with each other, this will reduce the responsiblity for one big coordinator class.)

Created a Main class to serve as the entry point of the game. This class will contain the main method.

Overall I did not change much in the game logic, just the organization of the files.

## Important
Is the Card interface and the classes that implement this interface a model?

1. Should we create a new package for Card and store them there? 

Because if Card is a model, then we are breaking MVC because the player class holds an instance of the Card(as an array). I cannot figure out how to break the dependency between them.

Reworked the Tile class and took out the displayInfo into a TileView and Tile controller. In the TileController the tight coupling is revealed because we have to import 2 other models for the Tilecontroller to work(Player and Gameboard). 

It seems this problem is everywhere(also in PlayerController and CardController), where we have to import Player and Gameboard models for the controllers to work.