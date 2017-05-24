package hangman.Round;

import hangman.Message.FormattedMessage;
import hangman.Message.Message;
import hangman.Message.MessageInterface;
import hangman.Puzzle.PuzzleInterface;
import hangman.Round.Result.Result;
import hangman.Round.Result.ResultInterface;

import java.io.PrintStream;

/**
 * Show state on failure
 * Stop game if we reach pur attempts
 */
public class MistakesTrack implements RoundInterface {
    private final MessageInterface mistakeMessage = new Message("Missed, mistake #%d out of %d\n");
    private final MessageInterface loseMessage = new Message("You lost\n");
    private final int attempts;
    private final RoundInterface original;
    private int mistakes;

    public MistakesTrack(int attempts, RoundInterface original) {
        this.attempts = attempts;
        this.original = original;
        this.mistakes = 0;
    }

    @Override
    public ResultInterface handle(PrintStream output, PuzzleInterface puzzle) {
        ResultInterface result = this.original.handle(output, puzzle);
        if (puzzle.progress() == result.puzzle().progress()) {
            this.mistakes = this.mistakes + 1;
            new FormattedMessage(this.mistakeMessage, this.mistakes, this.attempts)
                .send(output);
            if (this.mistakes == this.attempts) {
                result = new Result(puzzle, false);
                loseMessage.send(output);
            }
        }
        return result;
    }

}
