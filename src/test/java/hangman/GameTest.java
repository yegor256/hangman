package hangman;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void play1() throws Exception {
        final ByteArrayInputStream input = new ByteArrayInputStream(
                "h\ne\nl\no\n".getBytes()
        );
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        new Game("hello", 1, input, output).play();
        assertThat(output.toString(), containsString("You won"));
    }

    @Test
    public void play2() throws Exception {
        final ByteArrayInputStream input = new ByteArrayInputStream(
                "h\ne\nl\nl\n".getBytes()
        );
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        new Game("hello", 1, input, output).play();
        assertThat(output.toString(), containsString("You lost"));
    }

    @Test
    public void play3() throws Exception {
        final ByteArrayInputStream input = new ByteArrayInputStream(
                "e\no\na\nb\nl\nh\n".getBytes()
        );
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        new Game("hello", 3, input, output).play();
        assertThat(output.toString(), containsString("Guess a letter: Missed, mistake #1 out of 3"));
        assertThat(output.toString(), containsString("Guess a letter: Missed, mistake #2 out of 3"));
        assertThat(output.toString(), containsString("You won!"));
    }

}