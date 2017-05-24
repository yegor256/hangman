package hangman.Round;

import hangman.Message.Message;
import hangman.Message.MessageInterface;
import hangman.Puzzle.PuzzleInterface;
import hangman.Round.Result.ResultInterface;

import java.io.PrintStream;

/**
 *
 */
public class SuccessRoundTrack implements RoundInterface {
    private final MessageInterface message = new Message("Hit!\n");
    private final RoundInterface original;

    public SuccessRoundTrack(RoundInterface original) {
        this.original = original;
    }

    @Override
    public ResultInterface handle(PrintStream output, PuzzleInterface puzzle) {
        final ResultInterface result = this.original.handle(output, puzzle);
        if (result.puzzle().progress() > puzzle.progress()) {
            this.message.send(output);
        }
        return result;
    }
}
