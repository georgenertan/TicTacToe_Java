import java.util.Arrays;

public class GameBoard {
    Cell[][] board = new Cell[3][3];


    void init() {
        for (Cell[] cells : board) {
            Arrays.fill(cells, Cell.EMPTY);
        }
    }

    void print() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                switch (cell) {
                    case EMPTY ->
                        System.out.print("_" + " ");

                    case O ->
                        System.out.print("O" + " ");

                    default ->
                        System.out.print("X" + " ");

                }
            }
            System.out.println();
        }
        System.out.println();
    }


    boolean playerMove(int line, int col, Cell cell) {
        if(board[line - 1][col - 1] == Cell.EMPTY) {
            board[line -1][col -1] = cell;
            return true;
        } else {
            return false;
        }
    }

    GameState getGameState() {
        if (isWin(Cell.X)) {
            return GameState.X_WIN;
        }
        if (isWin(Cell.O)) {
            return GameState.O_WIN;
        }
        if (hasEmptyCells()) {
            return GameState.NOT_FINISHED;
        }
        return GameState.DRAW;
    }

    boolean isWin( Cell player) {
        for (Cell[] cells : board) {
            if (cells[0] == cells[1] && cells[1] == cells[2] && cells[2] == player) {
                return true;
            }
        }
        for (int j = 0; j < board.length; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[2][j] == player) {
                return true;
            }
        }
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == player) ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == player);
    }

    boolean hasEmptyCells() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.equals(Cell.EMPTY)) {
                    return true;
                }
            }
        }
        return false;
    }
}
