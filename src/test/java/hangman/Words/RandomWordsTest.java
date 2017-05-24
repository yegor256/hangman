package hangman.Words;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RandomWordsTest {

    @Test
    public void getRandomWordFromList() throws Exception {
        final String[] words = {"a", "b", "c"};
        final String word = new RandomWords(words).get();
        Assert.assertEquals(Arrays.asList(words).contains(word), true);
    }
}