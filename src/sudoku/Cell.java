package sudoku;

public class Cell {
    private int value;
    private final boolean FIXED;

    public Cell(int value, boolean FIXED) {
        this.value = value;
        this.FIXED = FIXED;
    }

    public int getValue() {
        return value;
    }

    public boolean isFIXED() {
        return FIXED;
    }

    public void setValue(int value) {
        if (!FIXED) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return (value == 0) ? "~" : String.valueOf(value);
    }
}
