package hangman.writer;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleWriterTest {

  private SimpleWriter writer;

  private OutputStream out;

  @Before
  public void setUp() {
    out = new ByteArrayOutputStream();
    writer = new SimpleWriter(out);
  }

  @Test
  public void shouldWrite() {
    final String expected = "test";

    writer.write(expected);

    assertThat(out.toString()).isEqualToIgnoringWhitespace(expected);
  }
}
