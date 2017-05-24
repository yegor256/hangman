package hangman.Round;

import hangman.Message.Message;
import hangman.Message.MessageInterface;
import hangman.Puzzle.PuzzleInterface;
import hangman.Round.Result.Result;
import hangman.Round.Result.ResultInterface;

import java.io.PrintStream;

/**
 * Stop game if we solved our puzzle
 */
public class SolvedTrack implements RoundInterface {
    private final MessageInterface message = new Message("You won!\n");
    private final RoundInterface original;

    public SolvedTrack(RoundInterface original) {
        this.original = original;
    }

    @Override
    public ResultInterface handle(PrintStream output, PuzzleInterface puzzle) {
        ResultInterface result = this.original.handle(output, puzzle);
        if (result.puzzle().progress() == 100) {
            message.send(output);
            result = new Result(result.puzzle(), false);
        }
        return result;
    }
}
