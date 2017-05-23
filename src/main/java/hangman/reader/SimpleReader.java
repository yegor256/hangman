package hangman.reader;

import java.io.InputStream;
import java.util.Scanner;

public class SimpleReader implements Reader {

  private final Scanner reader;

  public SimpleReader() {
    reader = new Scanner(System.in);
  }

  public SimpleReader(InputStream inputStream) {
    this.reader = new Scanner(inputStream);
  }

  @Override
  public int read() {
    return reader.next().charAt(0);
  }
}
