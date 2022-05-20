import java.util.Random;

public class Computer extends Player{



    int[] getRandomMove(GameBoard gameBoard) {
        int[][] moves = new int[9][2];
        int emptyCellsNO = 0;
        for(int i = 0; i < gameBoard.board.length; i++) {
            for (int j = 0; j < gameBoard.board[i].length; j++) {
                if (gameBoard.board[i][j].equals(Cell.EMPTY)) {
                    moves[emptyCellsNO][0] = i;
                    moves[emptyCellsNO][1] = j;
                    emptyCellsNO++;
                }

            }
        }
        Random random = new Random();
        int randomNr = random.nextInt(emptyCellsNO);
        return new int[]{moves[randomNr][0], moves[randomNr][1]};
    }

    @Override
    void move(GameBoard gameBoard, Round round) {
        int[] move = getRandomMove(gameBoard);
        gameBoard.playerMove(move[0] + 1, move[1] + 1, Cell.O);
    }
}
