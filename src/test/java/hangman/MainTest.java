package hangman;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public final class MainTest {

    @Test
    public void failsAfterManyWrongAttempts() {
        final ByteArrayInputStream input = new ByteArrayInputStream(
                "1\n1\n1\n1\n1\n".getBytes()
        );

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Secret secret = new Secret();
        new Hangman(
                new Mistakes(
                        new Attempt(
                                new Guess(input),
                                secret
                        ),
                        secret,
                        1
                )
        ).play();

        assertThat(outContent.toString(), containsString("You lost"));
    }

}
