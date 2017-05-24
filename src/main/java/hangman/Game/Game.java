package hangman.Game;

import hangman.Puzzle.Puzzle;
import hangman.Puzzle.PuzzleInterface;
import hangman.Round.Result.ResultInterface;
import hangman.Round.RoundInterface;
import hangman.Words.WordsInterface;

import java.io.PrintStream;

public class Game implements GameInterface {

    private final RoundInterface round;
    private final WordsInterface words;
    private PrintStream output;

    public Game(PrintStream output, WordsInterface words, RoundInterface round) {
        this.output = output;
        this.words = words;
        this.round = round;
    }


    @Override
    public void play() {
        PuzzleInterface puzzle = new Puzzle(words.get());
        while (true) {
            ResultInterface result = round.handle(this.output, puzzle);
            puzzle = result.puzzle();
            if (!result.next()) {
                break;
            }
        }
    }

}
