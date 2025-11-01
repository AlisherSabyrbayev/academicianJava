package sudoku;

public class SudokuBoard {
    private final int SIZE;
    private final Cell[][] board;

    public SudokuBoard(int SIZE, int[][] puzzle) {
        this.SIZE = SIZE;
        this.board = new Cell[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int value = puzzle[i][j];
                board[i][j] = new Cell(puzzle[i][j], puzzle[i][j] != 0);
            }
        }
    }

    public boolean isValidMove(int row, int col, int value) {
        if (value < 1 || value > SIZE) return false;

        // Проверка строки
        for (int j = 0; j < SIZE; j++) {
            if (board[row][j].getValue() == value) return false;
        }

        //проверка столбца
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col].getValue() == value) return false;
        }

        return true;
    }

    public void setCell(int row, int col, int value) {
        board[row][col].setValue(value);
    }

    public boolean isSolved() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].getValue() == 0) return false;
            }
        }
        return true;
    }

    public void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
