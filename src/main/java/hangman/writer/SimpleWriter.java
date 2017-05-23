package hangman.writer;

import java.io.OutputStream;
import java.io.PrintStream;

public class SimpleWriter implements Writer {
  private final PrintStream printStream;

  public SimpleWriter(OutputStream outputStream) {
    this.printStream = new PrintStream(outputStream);
  }

  public SimpleWriter() {
    printStream = System.out;
  }

  @Override
  public void write(String output) {
    printStream.println(output);
  }
}
