package hangman.Round;

import hangman.Puzzle.PuzzleInterface;
import hangman.Round.Result.ResultInterface;

import java.io.PrintStream;

public interface RoundInterface {
    ResultInterface handle(PrintStream output, PuzzleInterface puzzle);
}
