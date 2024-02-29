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

