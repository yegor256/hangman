package hangman.game;

import hangman.word.Word;

import java.util.Arrays;
import java.util.Random;

public class RandomWord {

    private final Random random;
    private final Word[] words;

    public RandomWord(Random random, Word[] words) {
        this.random = random;
        this.words = words;
    }

    public RandomWord(String[] words) {
        this(new Random(), mapArrayToWordArray(words));
    }

    private static Word[] mapArrayToWordArray(String[] words) {
        return Arrays.stream(words)
                     .map(Word::new)
                     .toArray(Word[]::new);
    }

    public RandomWord(Word[] words) {
        this(new Random(), words);
    }

    public Word pick() {
        return words[random.nextInt(words.length)];
    }
}

