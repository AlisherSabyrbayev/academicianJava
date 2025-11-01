package sudoku;

import java.util.Scanner;

public class SudokuGame {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choice dif-level: ");
            System.out.println("0 — Exit");
            System.out.println("1 — Easy (3x3");
            System.out.println("2 — Mid (6x6");
            int choice = SCANNER.nextInt();

            if (choice == 0) {
                System.out.println("You have left");
                return;
            }

            int[][] puzzle;
            int size;
            String level;

            if (choice == 1) {
                level = "Easy";
                size = 3;
                puzzle = new int[][]{
                        {1, 3, 0},
                        {0, 0, 0},
                        {0, 1, 0}
                };
            } else if (choice == 2) {
                level = "Mid";
                size = 6;
                puzzle = new int[][]{
                        {4, 0, 6, 0, 0, 2},
                        {0, 6, 0, 2, 1, 0},
                        {0, 5, 0, 0, 0, 3},
                        {5, 0, 0, 1, 0, 6},
                        {0, 2, 4, 0, 3, 0},
                        {6, 4, 0, 5, 2, 0}
                };
            } else {
                System.out.println("Invalid choice\n");
                continue;
            }

            SudokuBoard sudokuBoard = new SudokuBoard(size, puzzle);
            play(sudokuBoard);
            break;
        }
    }

    private static void play(SudokuBoard sudokuBoard) {
        System.out.println("\nSudoku game started");
        System.out.println("Enter the move in the format - <row> <column> <value>");
        System.out.println("To exit enter: 0 0 0\n");

        while (true) {
            sudokuBoard.displayBoard();

            if (sudokuBoard.isSolved()) {
                System.out.println("You are win");
                break;
            }

            System.out.print("Enter (<row> <column> <value>): ");
            int row = SCANNER.nextInt();
            int col = SCANNER.nextInt();
            int value = SCANNER.nextInt();

            if (row == 0 && col == 0 && value == 0) {
                System.out.println("You have left");
                break;
            }

            row--;
            col--;

            if (sudokuBoard.isValidMove(row, col, value)) {
                sudokuBoard.setCell(row, col, value);
            } else {
                System.out.println("Invalid move");
            }
        }
    }
}
