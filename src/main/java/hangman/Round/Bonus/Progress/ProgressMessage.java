package hangman.Round.Bonus.Progress;

import hangman.Message.MessageInterface;
import hangman.Puzzle.PuzzleInterface;

import java.io.PrintStream;
import java.util.Collections;

public class ProgressMessage implements MessageInterface {

    private final PuzzleInterface puzzle;

    public ProgressMessage(PuzzleInterface puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public void send(PrintStream stream) {
        int done = Math.round(puzzle.progress() / 10);
        stream.print(String.join("", Collections.nCopies(done, "+")));
        if (done > 0) {
            stream.print(">");
        }
        stream.print(String.join("", Collections.nCopies(10 - done, "-")));
        stream.print("\n");
    }
}
