package battleship;

public class Ship {
    private Coordinate[] coordinates;
    private boolean[] hits;

    public Ship(Coordinate[] coordinates) {
        this.coordinates = coordinates;
        this.hits = new boolean[coordinates.length];
    }

    public boolean hit(Coordinate shot) {
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].equals(shot) && !hits[i]) {
                hits[i] = true;
                return true;
            }
        }
        return false;
    }

    public boolean isSunk() {
        for (boolean hit : hits) {
            if (!hit)
                return false;
        }
        return true;
    }

    public Coordinate[] getCoordinates() {
        return coordinates;
    }
}
