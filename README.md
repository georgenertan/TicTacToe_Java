# TicTacToe_Java
  From de beginning, I want to say, that this is my first project, and was made using what I learned so far.
  The game can be played by 1 player(playing with the computer), or 2 players(playing with another person). For this, 
in the Game Class we have the method "getInfo". In this method, a command is read, using the Scanner Class. The command 
has to be:1 or 2(number of players). If the command is not "1" or "2" the user has to write the command again, until the 
command is "1" or "2".
  Next we need a board to play on. The "GamBoard" Class contains a bidimensional array, named "board", with a size of 
3X3. This array has 9 cells, and a cell can have the following values:X, O, EMPTY. This values are store in the "Cell Enum". The board has to be empty at the beginning of every game, and that is done in the same Class, by the method "init()". In this method, all cells of the board are initialized with the "EMPTY" value.
  After the number of players is set, there are 2 situations. First, let's take the case with 2 players.
  In the "User" Class, the "void move(GameBoard gameBoard, Round round)" method gets another command. This one represents the coordinates of a cell(where the player wants to make his move). This command is checked if it is correct. The command has to be 2 numbers, separated by a " " character. The numbers can be:1, 2, or 3(coordinates). If the command is incorrect, the user has to introduce it again, until it is correct. This check is done by the "checkCommand" method. If the check is true, then 
the chosen cell has to be checked if it si empty. And this is done in the "gameBoard.playerMove(coord1, coord2, cell)" method(in the "Gameboard" Class). coord1 and coord2, are the coordinates introduced by the user earlier, and cell has the value X or O(from "Cell" Enum). 
  The cell is set with the help of the "Round" Enum(X or O). In "Round round" we keep track of which player turn it is. 
After a move is made, the value of "round" changes. In " boolean playerMove" method, if the specified cell is "EMPTY", then it takes the value of "cell"(X or O), otherwise the player move is "false" and in the "move" method the user has to enter other coordinates, until those represents an empty cell. 
  After this stage, the game prints the board, and this is made by "print" method from "Gameboard". The board is printed, after every move. Once player1 completed his move, it is players2's turn. For this, "changeRound()" method changes the value 
of "round". 
  The game needs to be checked, after every move, if it is over or no. "gameOver()" does this, by checking all the possibilities: if a player won, or if the board has no empty cells(draw). This checking is made by "GameState getGameState",
where GameState is an Enum, which contains all the situations that can exist at a point in the game. This situations are checked with the help of "isWin( Cell player)" and "hasEmptyCells()". If the game is not over, then the next player can make his move. 
   The "Game" Class contains two attributes:Player player1, Player player2. player1 represents X, and player2 represents O.
In "start()" method, player1 makes the move:"player1.move(gameboard, round)". After this the round is changed(to O), and player2 makes the move:"player2.move(gameboard, round). Player1 is an "User" object all the thime, but player2 can be an "User" or "Computer" object.(depends on the number of players introduced at the beginning:"getInfo()").
  "Computer" is a Class where the computer makes his move. This move is made in a random way. 
"int[] getRandomMove(GameBoard gameBoard)" takes the coordinates of all the empty cells in a bidimensional aray, which has the size 9x2(9 cells, 2 coordinates). After that, a "random" Object chooses a line of this array, and returns an array with only 2 elements(coordinates of the cell). In the end, in this Class, we are Overriding the "move(GameBoard gameBoard, Round round)" method. Player2 makes the move for O, so "Computer" will always add O in the cell. 
  "Computer" move can be made in other ways. It can check which is the best move to make(in this way the user can never win). In the future, I will add this way to the project, and the user can choose the level, when he is playing with the Com(easy or hard).
  
  
  
  

