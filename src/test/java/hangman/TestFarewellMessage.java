package hangman;

import hangman.game.Farewell;
import hangman.guessing.Guesses;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public class TestFarewellMessage {

    @Test
    public void message_printed_on_loss() {
        var mockGuess = mock(Guesses.class);
        Mockito.when(mockGuess.make()).thenReturn(false);
        var out = new ByteArrayOutputStream();

        var farewell = new Farewell(mockGuess, out);
        farewell.say();

        assertThat(out.toString(), containsString("You lost! Better luck " +
                "next time."));
    }

    @Test
    public void message_printed_on_win() {
        var mockGuess = mock(Guesses.class);
        Mockito.when(mockGuess.make()).thenReturn(true);
        var out = new ByteArrayOutputStream();

        var farewell = new Farewell(mockGuess, out);
        farewell.say();

        assertThat(out.toString(), containsString("You won! Thanks for " +
                "playing."));
    }
}
