# MINESWEEPER GAME

Welcome to the Minesweeper game developed in Java! This project offers an interaction with the game through a dynamically generated minefield based on user inputs.<br/>

## About the Game

Minesweeper is a puzzle game where players need to safely clear an area containing hidden "mines". Players open the tiles on the board and use clues about the number of neighboring mines in each field to avoid the mines.<br/>

## How To Play

### Starting the Game

The game starts by asking the user to specify the dimensions of the minefield (rows and columns). The number of mines is determined based on these dimensions.<br/>

### Playing the Game:

Players enter the coordinates (row and column) of the cell they wish to reveal. Upon selecting a cell:<br/>
-If the cell contains a mine, the game ends.<br/>
-If the cell does not contain a mine, it reveals a number indicating how many adjacent cells contain mines.<br/>

### Winning the Game:

The player wins the game by opening all the cells that do not contain mines and not triggering any mines.<br/>

## Developer Map

This implementation features a developer map that can be activated within the code. The developer map displays the locations of all the mines, helping in debugging and understanding the layout of the game.<br/>

## Runing The Game

To play the game, simply clone this repository, compile the Java files, and run the main class. Ensure Java is installed on your machine.<br/>
ENJOY!
