package hangman.Words;

import org.junit.Assert;
import org.junit.Test;

public class CachedWordsTest {

    @Test
    public void alwaysReturnSameWord() throws Exception {
        final WordsInterface words = new CachedWords(new RandomWords(new String[]{"a", "b", "c"}));
        final String initialWord = words.get();
        Assert.assertEquals(initialWord, words.get());
        Assert.assertEquals(initialWord, words.get());
    }

}