package hangman;

import hangman.guessing.Guess;
import hangman.guessing.Guesses;
import hangman.guessing.UserGuess;
import hangman.word.Word;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestManyGuesses {

    @Test
    public void loses_if_makes_five_incorrect_guesses() {
        var mockGuess = mock(Guess.class);
        when(mockGuess.make()).thenReturn(false, false, false, false, false);
        var out = new ByteArrayOutputStream();

        var guesses = new Guesses(mockGuess, out);
        assertThat(guesses.make(), is(false));
        assertThat(out.toString(), containsString("Mistake 1 out of 5."));
    }

    @Test
    public void wins_if_guesses_reveal_word() {
        var userInput = new ByteArrayInputStream("o\nn\ne\n".getBytes());
        var guess = new UserGuess(new Word("one"), userInput,
                new ByteArrayOutputStream());

        var guesses = new Guesses(guess, new ByteArrayOutputStream());
        assertThat(guesses.make(), is(true));
    }

}