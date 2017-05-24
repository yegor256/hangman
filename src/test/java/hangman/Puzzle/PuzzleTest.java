package hangman.Puzzle;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class PuzzleTest {
    @Test
    public void containsChar() throws Exception {
        MatcherAssert.assertThat(
            new Puzzle("te").contains("e".charAt(0)),
            Matchers.is(true)
        );
    }

    @Test
    public void containsWithOpenedChars() throws Exception {
        MatcherAssert.assertThat(
            new Puzzle("te").open("e".charAt(0)).contains("e".charAt(0)),
            Matchers.is(false)
        );
    }

    @Test
    public void doesNotContainsChar() throws Exception {
        MatcherAssert.assertThat(
            new Puzzle("ta").contains("d".charAt(0)),
            Matchers.is(false)
        );
    }

    @Test
    public void unsolved() throws Exception {
        MatcherAssert.assertThat(
            new Puzzle("te").open("t".charAt(0)).progress(),
            Matchers.is(50F)
        );
    }

    @Test
    public void solved() throws Exception {
        MatcherAssert.assertThat(
            new Puzzle("tet")
                .open("t".charAt(0))
                .open("e".charAt(0))
                .progress(),
            Matchers.is(100F)
        );
    }

}