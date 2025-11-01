package battleship;

public class Coordinate {
    private final int row;
    private final int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof Coordinate coordinate) {
            return this.row == coordinate.row && this.col == coordinate.col;
        }

        return false;
    }
}
