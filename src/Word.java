import java.util.ArrayList;

public class Word {
    private final String word;
    private final ArrayList<Character> arrayListWord;

    public Word(String word) {
        this.word = word;
        this.arrayListWord = this.setArrayListWord(word);
    }

    private ArrayList<Character> setArrayListWord(String word) {
        ArrayList<Character> list = new ArrayList<Character>();

        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }

        return list;
    }

    public String getWord() {
        return this.word;
    }

    public ArrayList<Character> getArrayListWord() {
        return this.arrayListWord;
    }

    public int getTotalOfCharacters() {
        return this.word.length();
    }

    public boolean contains(char c) {
        return this.getArrayListWord().contains(c);
    }
}
