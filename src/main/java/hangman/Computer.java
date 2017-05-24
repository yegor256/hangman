package hangman;

import hangman.word.HiddenWord;
import hangman.word.RandomWord;
import hangman.word.Word;

import java.util.HashSet;
import java.util.Set;

class Computer {

    private final Word goal;
    private final Set<Character> suggested = new HashSet<>();

    Computer(final Word... words) {
        this.goal = new RandomWord(words);
    }

    void suggest(char c) {
        suggested.add(c);
    }


    Word hiddenWord() {
        return new HiddenWord(goal, suggested);
    }
}
