package hangman;

import org.junit.Test;

public class ConditionTest {

    @Test
    public void alive() throws Exception {
        Condition condition = new Condition("test", 5);
        assert(condition.alive(0));
        assert(condition.alive(1));
        assert(!condition.alive(5));
    }

    @Test
    public void correctWord() throws Exception {
        Condition condition = new Condition("test", 5);
        assert(condition.correctWord("test"));
        assert(!condition.correctWord("bar"));
        assert(!condition.correctWord("TEST"));
    }

}