package pairs;

import java.util.Random;

public class Board {
    private final int size = 4;
    private Card[][] grid;

    public Board() {
        grid = new Card[size][size];
        initBoard();
    }

    private void initBoard() {
        String[] values = {"A","A","B","B","C","C","D","D",
                "E","E","F","F","G","G","H","H"};

        /*    private void initBoard() {
                  String[] values = {"A","A","B","B","C","C","D","D",
                          "E","E","F","F","G","G","H","H"};           */

        // перемешиваем массив значений
        Random rand = new Random();
        for (int i = 0; i < values.length; i++) {
            int j = rand.nextInt(values.length);
            String temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }

        // раскладываем по полю
        int index = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = new Card(values[index++]);
            }
        }
    }

    public void corner() {
        System.out.print("   ");
        for (int c = 0; c < size; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

        for (int r = 0; r < size; r++) {
            System.out.print(r + "  ");
            for (int c = 0; c < size; c++) {
                System.out.print(grid[r][c].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public boolean flipCards(int row1, int column1, int row2, int column2) {
        Card first = grid[row1][column1];
        Card second = grid[row2][column2];

        if (first.isMatched() || second.isMatched() || first == second) {
            System.out.println("Invalid move");
            return false;
        }

        first.reveal();
        second.reveal();
        clear();
        corner();

        if (first.getValue().equals(second.getValue())) {
            System.out.println("Match found");
            first.setMatched();
            second.setMatched();
            return true;
        } else {
            System.out.println("Not match");
            first.hide();
            second.hide();
            clear();
            corner();
            return false;
        }
    }

    public boolean allMatched() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (!grid[r][c].isMatched())
                    return false;
            }
        }
        return true;
    }

    private void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}