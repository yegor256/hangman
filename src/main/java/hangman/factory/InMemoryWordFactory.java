package hangman.factory;

import java.util.Random;

public class InMemoryWordFactory implements WordFactory {

  private static final String[] WORDS = {
    "simplicity", "equality", "grandmother",
    "neighborhood", "relationship", "mathematics",
    "university", "explanation"
  };

  private static final Random random = new Random();

  @Override
  public String getWord() {
    return WORDS[random.nextInt(WORDS.length)];
  }
}
