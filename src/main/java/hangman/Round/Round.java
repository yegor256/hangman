package hangman.Round;

import hangman.Message.Message;
import hangman.Puzzle.PuzzleInterface;
import hangman.Round.Result.Result;
import hangman.Round.Result.ResultInterface;

import java.io.PrintStream;
import java.util.Iterator;

/**
 * Standard implementation of the round
 * Ask a letter -> open if present
 */
public class Round implements RoundInterface {
    private final Message question = new Message("Guess a letter: ");
    private final Iterator<String> scanner;

    public Round(Iterator<String> scanner) {
        this.scanner = scanner;
    }

    @Override
    public ResultInterface handle(PrintStream output, PuzzleInterface puzzle) {
        this.question.send(output);
        final Character character = this.scanner.next().charAt(0);
        if (puzzle.contains(character)) {
            puzzle = puzzle.open(character);
        }
        return new Result(puzzle, true);
    }
}
