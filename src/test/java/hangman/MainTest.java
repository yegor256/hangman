package hangman;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertFalse;

public final class MainTest {

    @Test
    public void failsAfterManyWrongAttempts() {
        final ByteArrayInputStream input = new ByteArrayInputStream(
                "1\n2\n".getBytes()
        );

        Secret secret = new Secret();
        Boolean gameResult = new Hangman(
                new Attempt(
                        new UserInput(input),
                        secret
                ),
                secret,
                1
        ).play();

        assertFalse(gameResult);
    }
}
