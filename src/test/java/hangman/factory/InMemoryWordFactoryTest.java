package hangman.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InMemoryWordFactoryTest {
  private WordFactory wordFactory;

  @Before
  public void setUp() {
    wordFactory = new InMemoryWordFactory();
  }

  @Test
  public void shouldGenerate() {
    String actual = wordFactory.getWord();

    Assert.assertTrue(!actual.isEmpty());
  }
}
