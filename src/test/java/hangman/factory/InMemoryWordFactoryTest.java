package hangman.factory;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryWordFactoryTest {
  private WordFactory wordFactory;

  @Before
  public void setUp() {
    wordFactory = new InMemoryWordFactory();
  }

  @Test
  public void shouldGenerate() {
    String actual = wordFactory.getWord();

    assertThat(actual).isNotBlank();
  }
}
