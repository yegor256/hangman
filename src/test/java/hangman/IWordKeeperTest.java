package hangman;

import hangman.exceptions.WordAlreadyOpenException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by teSGreat on 24.05.2017.
 */
public class IWordKeeperTest {

    private final String word = "johnny";
    private final char[] chars = word.toCharArray();
    private IWordKeeper wk;

    @Before
    public void setUp() throws Exception {
        wk = new WordKeeper(word);
    }

    @Test
    public void test_find_not_all_letters() throws Exception {

        for (int i = 0; i < chars.length - 1; i++) {
            wk.findLetter(chars[i]);
        }

        assertThat(wk.isOpen(), is(false));
    }


    @Test
    public void test_find_all_letters() throws Exception {

        for (int i = 0; i < chars.length; i++) {
            wk.findLetter(chars[i]);
        }
        assertThat(wk.isOpen(), is(true));
    }

    @Test(expected = WordAlreadyOpenException.class)
    public void test_exception_if_word_open() throws Exception {

        for (int i = 0; i < chars.length; i++) {
            wk.findLetter(chars[i]);
        }

        wk.findLetter(chars[0]);
        assertThat(wk.isOpen(), is(true));
    }
}