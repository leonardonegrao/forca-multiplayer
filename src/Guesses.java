import java.util.ArrayList;

public class Guesses {

    private final ArrayList<Character> guesses;

    public Guesses() {
        this.guesses = new ArrayList<Character>();
    }

    public ArrayList<Character> getGuesses() {
        return this.guesses;
    }

    public String getGuessesToString() {
        return this.guesses.toString();
    }

    public boolean setGuesses(char guess) {
        if (this.guesses.contains(guess)) {
            return false;
        }

        this.guesses.add(guess);
        return true;
    }

    public boolean contains(char guess) {
        return this.guesses.contains(guess);
    }

    public void add(char character) {
        this.guesses.add(character);
    }
}
