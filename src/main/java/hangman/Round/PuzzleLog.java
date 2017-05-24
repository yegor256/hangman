package hangman.Round;

import hangman.Message.FormattedMessage;
import hangman.Message.Message;
import hangman.Message.MessageInterface;
import hangman.Puzzle.PuzzleInterface;
import hangman.Round.Result.ResultInterface;

import java.io.PrintStream;

/**
 * Show puzzle to the user
 */
public class PuzzleLog implements RoundInterface {
    private final MessageInterface message = new Message("The word: %s \n\n");
    private final RoundInterface original;

    public PuzzleLog(RoundInterface original) {
        this.original = original;
    }

    @Override
    public ResultInterface handle(PrintStream output, PuzzleInterface puzzle) {
        final ResultInterface result = this.original.handle(output, puzzle);
        new FormattedMessage(this.message, result.puzzle().state())
            .send(output);
        return result;
    }
}
