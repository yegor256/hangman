package hangman.Words;


import java.util.Random;

public class RandomWords implements WordsInterface {

    private final String[] words;

    public RandomWords(String[] words) {
        this.words = words;
    }

    @Override
    public String get() {
        final String word = words[new Random().nextInt(words.length)];
        if (word.isEmpty()) {
            throw new IllegalArgumentException("Invalid word format. Word should not be empty.");
        }
        return word;
    }

}
