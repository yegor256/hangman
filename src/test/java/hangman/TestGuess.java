package hangman;

import hangman.guessing.Guess;
import hangman.guessing.UserGuess;
import hangman.word.Word;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestGuess {

    final String promptMessage = "\nGuess a letter: ";

    Guess guess;
    ByteArrayOutputStream out;

    private void setup(String input) {
        var in = new ByteArrayInputStream(input.getBytes());
        out = new ByteArrayOutputStream();
        var word = new Word("any");
        guess = new UserGuess(word, in, out);
    }

    @Test
    public void makes_correct_guess() {
        setup("a");
        boolean isRight = guess.make();

        assertThat(out.toString(), is("_ _ _" + promptMessage));
        assertThat(isRight, is(true));
    }

    @Test
    public void makes_wrong_guess() {
        setup("b");

        boolean isRight = guess.make();

        assertThat(out.toString(), is("_ _ _" + promptMessage));
        assertThat(isRight, is(false));
    }

}
