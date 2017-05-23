package hangman.writer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

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

    Assert.assertTrue(out.toString().contains(expected));
  }
}
