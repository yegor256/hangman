package hangman;

import hangman.word.Word;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestWord {

    Word word;

    @Before
    public void newWord() {
        word = new Word("one");
    }

    @Test
    public void word_is_hidden_at_first() {
        assertThat(word.toString(), is("_ _ _"));
    }

    @Test
    public void word_reveals_first_letter() {
        word.guess('o');
        assertThat(word.toString(), is("o _ _"));
    }

    @Test
    public void word_reveals_second_letter() {
        word.guess('n');
        assertThat(word.toString(), is("_ n _"));
    }

    @Test
    public void word_is_fully_revealed_if_all_letters_revealed() {
        word.guess('o');
        word.guess('n');
        word.guess('e');
        assertThat(word.revealed(), is(true));
    }

    @Test
    public void if_guess_is_correct_we_get_informed() {
        assertThat(word.guess('e'), is(true));
    }

    @Test
    public void reveals_two_letters_at_once() {
        word = new Word("barbara");
        word.guess('b');
        assertThat(word.toString(), is("b _ _ b _ _ _"));
    }

    @Test
    public void reveals_even_if_uppercase() {
        word.guess('O');
        assertThat(word.toString(), is("o _ _"));
    }
}
