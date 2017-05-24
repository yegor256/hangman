package hangman.Puzzle;

import hangman.Message.MessageInterface;

public interface PuzzleInterface {

    boolean contains(Character letter);

    float progress();

    PuzzleInterface open(Character letter);

    MessageInterface state();

}
