package battleship;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first player's name:");
        Player player1 = new Player(scanner.nextLine(), 5);

        System.out.println("Enter the second player's name:");
        Player player2 = new Player(scanner.nextLine(), 5);

        Player current = player1;
        Player opponent = player2;

        while (true) {
            System.out.println("\nField " + current.getName() + ":");
            current.printBoard(false);

            System.out.println("\nEnemy's field:");
            opponent.printBoard(true);

            current.takeShot(opponent, scanner);

            if (opponent.allShipsSunk()) {
                System.out.println(current.getName() + " won!");
                break;
            }

            // меняем ход
            Player temp = current;
            current = opponent;
            opponent = temp;
        }
    }

    public void swapPlayers(Player p1, Player p2) {
        // меняем ход
        Player temp = p1;
        p1 = p2;
        p2 = temp;
    }
}
