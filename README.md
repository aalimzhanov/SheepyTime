# SheepyTime

A draft of Sheepy Time game

## Do NOT commit anything to the main branch!!!

## Initial commit notes:

`Sheep` might have to be reworked. There is no reason to hold a reference to a player. The gameboard can associate player and sheep by the color.

`SheepyCard` logic needs to be reworked. Eeach card can have different options: "or", "and", etc..

`Player` logic needs to be complete. Unclear on how to handle playing a card or making a resting move.

`Deck` logic is complete.

`Tile` logic is incomplete. Do we store actionType as a String or ActionType enum? Also when using a token, do we pass in the token we want to use up? We could alternatively pass the player match a token based on colors and use that.

`TileDeck` logic is complete.

`PlayerController` in the `playARacingMove` how does a player get a new card?

## Second commit notes:

`Card`, `PlayerController`, `Player`, `GameBoard`, `Sheep`, and all `Card` implementations are almost done. See comments in the code for more details.

`Tile`, `Nightmare` and `ScoreBoard` logic missing


## Add more game logic that is missing below:

How do we deal with 'Calling it a Night', or rather which class should deal with that

## Changes I made
The main changes was organizing the classes into packages. This made it easier to detect MVC violations.

This how you detect that: 
1. Every Controller should import its own model and view.
2. Every view should import only its corresponding model.
3. A model should not import a view or controller under no circumstances.

We should have a class (or this can be made in the main class) which initializes the game and all of the game environment. This class should be outside the packages.

Right now our Player model is breaking MVC because it imports controllers and other models to work. (I just checked your updated code and it seems this is fixed).

Reworked the Nightmare controller and Nightmare view to adhere to MVC

Reworked the Gameboard controller and Gameboard view to adhere to MVC

Removed view interface because we do not need it

Created a Coordinator class which creates and initializes all the controllers and handles the interaction between them. (We can create Coordinator classes for specific controllers that need to interact with each other, this will reduce the responsiblity for one big coordinator class.)

Created a Main class to serve as the entry point of the game. This class will contain the main method.




