package hangman;

import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by teSGreat on 24.05.2017.
 */
public class IHangmanTest {

    private final int maxErrors = 5;
    private final String word = "johnny";
    private final char wrongChar = 'g';
    private IHangman h;

    @Before
    public void setUp() throws Exception {
        IWordKeeper wk = new WordKeeper(word);
        h = new SuperHangman(wk, maxErrors);
    }

    @Test
    public void answer_correcty_not_to_end() throws Exception {

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length - 2; i++) {
            h.hitMe(chars[i]);
        }

        assertThat(h.isAlive(), is(true));
        assertThat(h.winner(), is(false));
        assertThat(h.attemptsRemained(), is(maxErrors));
    }

    @Test
    public void answer_with_1_error() throws Exception {

        h.hitMe(wrongChar);
        assertThat(h.isAlive(), is(true));
        assertThat(h.winner(), is(false));
        assertThat(h.attemptsRemained(), is(maxErrors - 1));
    }

    @Test
    public void answer_with_max_minus_1_errors() throws Exception {

        int steps = maxErrors - 1;
        for (int i = 0; i < steps; i++) {
            h.hitMe(wrongChar);
        }
        assertThat(h.isAlive(), is(true));
        assertThat(h.winner(), is(false));
        assertThat(h.attemptsRemained(), is(1));
    }

    @Test
    public void answer_with_one_right_letter_more_than_maxx_errors_times() throws Exception {

        for (int i = 0; i < maxErrors + 1; i++) {
            h.hitMe(word.charAt(0));
        }

        assertThat(h.isAlive(), is(false));
        assertThat(h.winner(), is(false));
        assertThat(h.attemptsRemained(), is(0));
    }

    @Test
    public void answer_all_correctry_is_winner() throws Exception {

        Set<Character> uniqChars = new HashSet<>();
        for (char ch : word.toCharArray()) {
            uniqChars.add(ch);
        }

        for (char ch : uniqChars) {
            h.hitMe(ch);
        }

        assertThat(h.isAlive(), is(true));
        assertThat(h.winner(), is(true));
        assertThat(h.attemptsRemained(), is(maxErrors));
    }

}