package hangman.Puzzle;

import hangman.Message.Message;
import hangman.Message.MessageInterface;

import java.util.ArrayList;
import java.util.List;

public class Puzzle implements PuzzleInterface {


    private final List<Character> word;
    private final List<Character> matched;

    public Puzzle(String word) {
        this(word, new ArrayList<>());
    }

    private Puzzle(String word, List<Character> matched) {
        final String[] letters = word.split("");
        ArrayList<Character> chars = new ArrayList<>();
        for (String letter : letters) {
            chars.add(letter.charAt(0));
        }
        this.word = chars;
        this.matched = matched;
    }

    private Puzzle(List<Character> word, List<Character> matched) {
        this.word = word;
        this.matched = matched;
    }

    @Override
    public boolean contains(Character letter) {
        return this.word.contains(letter) && !matched.contains(letter);
    }

    @Override
    public PuzzleInterface open(Character letter) {
        if (!contains(letter)) {
            throw new IllegalArgumentException("PuzzleInterface does not contain letter " + letter);
        }
        final List<Character> matched = new ArrayList<>(this.matched);
        matched.add(letter);
        return new Puzzle(word, matched);
    }

    @Override
    public MessageInterface state() {
        final StringBuilder result = new StringBuilder(0);
        for (Character letter : this.word) {
            result.append(
                matched.contains(letter) ? letter : "?"
            );
        }
        return new Message(result.toString());
    }

    @Override
    public float progress() {
        int solved = 0;
        for (Character letter : this.word) {
            if (matched.contains(letter)) {
                solved++;
            }
        }
        return (solved * 100 / this.word.size());
    }
}
