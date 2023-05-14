package hangman;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by teSGreat on 24.05.2017.
 */
public class IHangmanSurvialTest {

    private final int maxErrors = 5;
    private IWordKeeper wk = new WordKeeper("johnny");

    @Test
    public void win_answers() throws Exception {
        final InputStream input = new ByteArrayInputStream("j\no\nh\nn\ny\n".getBytes());
        IHangman h = new SuperHangman(wk, maxErrors, input, System.out);
        h.trySurvive();

        assertThat(h.isAlive(), is(true));
        assertThat(h.winner(), is(true));
        assertThat(h.attemptsRemained(), is(maxErrors));
    }

    @Test
    public void lose_with_some_one_answer() throws Exception {

        final InputStream input = new ByteArrayInputStream("j\nj\nj\nj\nj\nj\n".getBytes());
        IHangman h = new SuperHangman(wk, maxErrors, input, System.out);
        h.trySurvive();

        assertThat(h.isAlive(), is(false));
        assertThat(h.winner(), is(false));
        assertThat(h.attemptsRemained(), is(0));
    }


    @Test
    public void lose_many_wrong_answer() throws Exception {

        final InputStream input = new ByteArrayInputStream("d\na\nr\nv\ni\n".getBytes());
        IHangman h = new SuperHangman(wk, maxErrors, input, System.out);
        h.trySurvive();

        assertThat(h.isAlive(), is(false));
        assertThat(h.winner(), is(false));
        assertThat(h.attemptsRemained(), is(0));
    }

    @Test
    public void not_all_answers() throws Exception {

        final InputStream input = new ByteArrayInputStream("j\no\nh\n".getBytes());
        IHangman h = new SuperHangman(wk, maxErrors, input, System.out);
        h.trySurvive();

        assertThat(h.isAlive(), is(true));
        assertThat(h.winner(), is(false));
        assertThat(h.attemptsRemained(), is(maxErrors));
    }

    @Test
    public void test_with_opened_word_keeper_already_winner() throws Exception {

        final InputStream input = new ByteArrayInputStream("j\n".getBytes());

        WordKeeper openedWk = new WordKeeper("j");
        openedWk.findLetter('j');
        assertThat(openedWk.isOpen(), is(true));

        IHangman h = new SuperHangman(openedWk, maxErrors, input, System.out);
        h.trySurvive();

        assertThat(h.isAlive(), is(true));
        assertThat(h.winner(), is(true));
        assertThat(h.attemptsRemained(), is(maxErrors));
    }

}