package battleship;

public class Cell {
    enum State { EMPTY, SHIP, HIT, MISS }

    private State state;

    public Cell() {
        this.state = State.EMPTY;
    }

    public void setShip() {
        this.state = State.SHIP;
    }

    public boolean hasShip() {
        return state == State.SHIP;
    }

    public void hit() {
        // What if state is HIT or MISS ?!
        if (state == State.SHIP) {
            state = State.HIT;
        } else if (state == State.EMPTY) {
            state = State.MISS;
        }
    }

    public char getSymbol(boolean hideShip) {
        switch (state) {
            case EMPTY: return '.';
            case SHIP:  return hideShip ? '.' : 'O';
            case HIT:   return 'X';
            case MISS:  return '*';
            default:    return '?';
        }
    }
}
