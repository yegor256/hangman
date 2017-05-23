package hangman.reader;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class SimpleReaderTest {

  private Reader reader;

  private final String data = "a\n";

  @Before
  public void setUp() {
    reader = new SimpleReader(new ByteArrayInputStream(data.getBytes()));
  }

  @Test
  public void shouldRead() {
    int actual = reader.read();

    Assertions.assertThat(actual).isEqualTo(data.charAt(0));
  }
}
