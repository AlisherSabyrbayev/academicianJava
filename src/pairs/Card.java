package pairs;

public class Card {
    private final String value;
    private boolean revealed;
    private boolean matched;

    public Card(String value) {
        this.value = value;
        this.revealed = false;
        this.matched = false;
    }

    public String getValue() {
        return value;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public boolean isMatched() {
        return matched;
    }

    public void reveal() {
        if (!matched) {
            revealed = true;
        }
    }

    public void hide() {
        if (!matched) {
            revealed = false;
        }
    }

    public void setMatched() {
        matched = true;
        revealed = true;
    }

    public char getSymbol() {
        return (matched || revealed) ? value.charAt(0) : '*';
    }
}
