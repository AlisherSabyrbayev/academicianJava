package pairs;

import java.util.Scanner;

public class Game implements Playable {
    private final Board board;

    public Game() {
        board = new Board();
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Найди пары. Соотнеси одинаковые координаты");

        while (!isFinished()) {
            board.corner();
            System.out.println("Enter coordinates of first card (row col): ");
            System.out.println("Enter row ( 0 - 3): ");
            int row1 = scanner.nextInt();
            System.out.println("Enter column ( 0 - 3): ");
            int column1 = scanner.nextInt();


            System.out.println("Enter coordinates of second card (row col): ");
            System.out.println("Enter row ( 0 - 3): ");
            int row2 = scanner.nextInt();
            System.out.println("Enter column ( 0 - 3): ");
            int column2 = scanner.nextInt();

            board.flipCards(row1, column1, row2, column2);
        }

        System.out.println("End. You found all pairs!");
    }

    @Override
    public boolean isFinished() {
        return board.allMatched();
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
