import java.util.ArrayList;
import java.util.stream.Collectors;

public class CurrentState {
    private final Word secretWord;
    private final Guesses rightGuesses = new Guesses();
    private final Guesses wrongGuesses = new Guesses();

    public CurrentState(String word) {
        this.secretWord = new Word(word);
    }

    public String getCurrentState() {
        return ("Palavra secreta: " + this.getWord() + "\n"
            + "Acertos: " + this.rightGuesses.getGuessesToString() + "\n"
            + "Erros: " + this.wrongGuesses.getGuessesToString() + "\n");
    }

    public String getWord() {
        ArrayList<Character> word = this.formatWord();

        return word.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public ArrayList<Character> formatWord() {
        ArrayList<Character> word = new ArrayList<Character>(this.secretWord.getTotalOfCharacters());
        word.addAll(this.secretWord.getArrayListWord());

        for (int i = 0; i < word.size(); i++) {
            if (!this.rightGuesses.contains(word.get(i))) {
                word.set(i, '_');
            }
        }

        return word;
    }

    public void handleGuess(String guess) {
        char characterGuessed = guess.toUpperCase().charAt(0);
        if (this.alreadyGuessed(characterGuessed)) {
            return;
        }

        this.saveGuess(characterGuessed);
        this.verifyIfWordGuessed();
    }

    public boolean alreadyGuessed(char character) {
        return (rightGuesses.contains(character) || wrongGuesses.contains(character));
    }

    private void saveGuess(char guess) {
        if (this.secretWord.contains(guess)) {
            this.rightGuesses.add(guess);
        } else {
            this.wrongGuesses.add(guess);
        }
    }

    private void verifyIfWordGuessed() {
        if (!this.formatWord().contains('_')) {
            System.out.println("Você venceu! A palavra era: " + this.secretWord.getWord());
            System.exit(0);
        }
    }
}
