package hangman.word;

public class Word {
    private final Letters letters;

    public Word(String word) {
        this.letters = new Letters(word);
    }

    @Override
    public String toString() {
        return letters.toString();
    }

    public boolean guess(char letter) {
        return letters.reveal(Character.toLowerCase(letter));
    }

    public boolean revealed() {
        return letters.allVisible();
    }
}
