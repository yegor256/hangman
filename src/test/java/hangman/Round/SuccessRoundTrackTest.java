package hangman.Round;

import hangman.Puzzle.Puzzle;
import hangman.Puzzle.PuzzleInterface;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SuccessRoundTrackTest {
    @Test
    public void handle() throws Exception {
        final ByteArrayInputStream input = new ByteArrayInputStream(
            "t\n".getBytes()
        );
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        PuzzleInterface puzzle = new Puzzle("test");
        new SuccessRoundTrack(new Round(new Scanner(input)))
            .handle(new PrintStream(output), puzzle);
        assertThat(output.toString(), containsString("Hit!"));
    }

}