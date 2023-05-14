package hangman;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoundTest {

    @Test
    public void getWordAfterRound() throws Exception {
        Game game = new Game("test", 5, null, null);
        Round round = new Round(game, 't');
        assert(round.getWordAfterRound().equals("t??t"));
    }

    @Test
    public void haveHit() throws Exception {
        Round round;
        Game game = new Game("test", 5, null, null);
        round = new Round(game, 't');
        assert(round.haveHit());
        round = new Round(game, 'e');
        assert(round.haveHit());
        round = new Round(game, 's');
        assert(round.haveHit());
        round = new Round(game, 'a');
        assert(!round.haveHit());
    }

}