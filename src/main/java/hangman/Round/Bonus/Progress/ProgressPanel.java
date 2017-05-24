package hangman.Round.Bonus.Progress;

import hangman.Puzzle.PuzzleInterface;
import hangman.Round.Result.ResultInterface;
import hangman.Round.RoundInterface;

import java.io.PrintStream;

/**
 * Show nice progress bar for the user
 */
public class ProgressPanel implements RoundInterface {
    private final RoundInterface original;

    public ProgressPanel(RoundInterface original) {
        this.original = original;
    }

    @Override
    public ResultInterface handle(PrintStream output, PuzzleInterface puzzle) {
        final ResultInterface result = this.original.handle(output, puzzle);
        new ProgressMessage(result.puzzle()).send(output);
        return result;
    }
}
