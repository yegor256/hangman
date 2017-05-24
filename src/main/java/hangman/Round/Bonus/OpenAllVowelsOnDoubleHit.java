package hangman.Round.Bonus;

import hangman.Puzzle.PuzzleInterface;
import hangman.Round.Result.Result;
import hangman.Round.Result.ResultInterface;
import hangman.Round.RoundInterface;

import java.io.PrintStream;

/**
 *
 */
public class OpenAllVowelsOnDoubleHit implements RoundInterface {
    private final RoundInterface original;
    private boolean previousHit = false;
    private String[] vowels = {"a", "e", "i", "o", "u", "y"};

    public OpenAllVowelsOnDoubleHit(RoundInterface original) {
        this.original = original;
    }

    @Override
    public ResultInterface handle(PrintStream output, PuzzleInterface puzzle) {
        ResultInterface result = this.original.handle(output, puzzle);
        PuzzleInterface newPuzzle = result.puzzle();
        final boolean currentHit = (newPuzzle.progress() > puzzle.progress());
        if (previousHit && currentHit) {
            for (String vowel : vowels) {
                char letter = vowel.charAt(0);
                if (newPuzzle.contains(letter)) {
                    newPuzzle = newPuzzle.open(letter);
                }
            }
            result = new Result(newPuzzle, result.next());
        }
        previousHit = currentHit;
        return result;
    }

}
