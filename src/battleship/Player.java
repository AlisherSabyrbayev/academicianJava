package battleship;

import java.util.Scanner;

public class Player {
    private final String name;
    private final Board board;

    public Player(String name, int shipCount) {
        this.name = name;
        this.board = new Board(shipCount);
    }

    public String getName() {
        return name;
    }

    public boolean allShipsSunk() {
        return board.allSunk();
    }

    public boolean shoot(Coordinate coordinate) {
        return board.shoot(coordinate);
    }

    public void printBoard(boolean hideShips) {
        board.print(hideShips);
    }

    public boolean takeShot(Player opponent, Scanner scanner) {
        System.out.println(name + ", enter the coordinates of the shot (row col): ");
        System.out.println("enter the row: ");
        int r = scanner.nextInt();
        System.out.println("enter the column");
        int c = scanner.nextInt();
        return opponent.shoot(new Coordinate(r, c));
    }
}
