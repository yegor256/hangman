package hangman;

import hangman.game.RandomWord;
import hangman.word.Word;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMakeRandomWord {
    Word word1 = new Word("wordone");
    Word word2 = new Word("wordtwo");
    Word[] words = {word1, word2};

    Random mockRandom = mock(Random.class);

    @Test
    public void randomly_picks_first_word() {
        when(mockRandom.nextInt(2)).thenReturn(0);

        RandomWord randomWord = new RandomWord(mockRandom, words);

        assertThat(randomWord.pick(), is(word1));
    }

    @Test
    public void randomly_picks_second_word() {
        when(mockRandom.nextInt(2)).thenReturn(1);

        RandomWord randomWord = new RandomWord(mockRandom, words);

        assertThat(randomWord.pick(), is(word2));
    }
}
