package hangman;

import hangman.guessing.GuessResult;
import hangman.guessing.UserGuess;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestPrintingGuessResult {

    @Test
    public void prints_message_that_guess_is_correct() {
        var mockGuess = mock(UserGuess.class);
        when(mockGuess.make()).thenReturn(true);
        var out = new ByteArrayOutputStream();

        boolean result = new GuessResult(mockGuess, out).make();
        assertThat(result, is(true));
        assertThat(out.toString(), is("\nHit!\n"));
    }

    @Test
    public void prints_message_that_guess_is_not_correct() {
        var mockGuess = mock(UserGuess.class);
        when(mockGuess.make()).thenReturn(false);
        var out = new ByteArrayOutputStream();

        boolean result = new GuessResult(mockGuess, out).make();
        assertThat(result, is(false));
        assertThat(out.toString(), is("\nMiss!\n"));
    }
}
