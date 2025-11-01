package battleship;

import java.util.Random;

public class Board {
    int size = 10;
    Cell[][] grid = new Cell[size][size];
    Ship[] ships;

    public Board(int shipCount) {
        // пустое поле
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }

        ships = new Ship[shipCount];
        placeShips();
    }

    private void placeShips() {
        Random random = new Random();

        int[] shipSizes = {4, 3, 3};
        ships = new Ship[shipSizes.length];

        for (int i = 0; i < shipSizes.length; i++) {
            boolean placed = false;

            while (!placed) {
                int r = random.nextInt(size);
                int c = random.nextInt(size);
                boolean horizontal = random.nextBoolean(); // t горизонт (column), f вертикаль (row)

                Coordinate[] coords = new Coordinate[shipSizes[i]];
                boolean valid = true;

                for (int k = 0; k < shipSizes[i]; k++) {
                    int nr = r + (horizontal ? 0 : k);
                    int nc = c + (horizontal ? k : 0);

                    if (nr >= size || nc >= size || grid[nr][nc].hasShip()) {
                        valid = false;
                        break;
                    }
                    coords[k] = new Coordinate(nr, nc);
                }

                if (valid) {
                    ships[i] = new Ship(coords);
                    for (Coordinate coord : coords) {
                        grid[coord.getRow()][coord.getCol()].setShip();
                    }
                    placed = true;
                }
            }
        }
    }


    public boolean shoot(Coordinate shot) {
        grid[shot.getRow()][shot.getCol()].hit();

        for (Ship ship : ships) {
            if (ship.hit(shot)) {
                System.out.println(ship.isSunk() ? "Ship sunk!" : "Hit!");
                return true;
            }
        }
        System.out.println("Miss!");
        return false;
    }

    public boolean allSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) return false;
        }
        return true;
    }


    public void print(boolean hideShips) {
        System.out.print("  ");
        for (int i = 0; i < size; i++) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getSymbol(hideShips) + " ");
            }
            System.out.println();
        }
    }
}
