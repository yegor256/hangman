package hangman.writer;

import hangman.strategy.status.GameStatus;

public class RoundReporter implements Reporter {
  @Override
  public String report(GameStatus status, String word) {
    StringBuilder builder = new StringBuilder();
    if (status.isHit()) {
      builder.append("Hit!\n");
    } else {
      builder.append(
          String.format(
              "Missed, mistake #%d out of %d%n",
              status.getMissCount(), status.getMaxMissCount()));
    }

    builder.append("The word: ");
    boolean[] hits = status.getHits();
    for (int i = 0; i < word.length(); ++i) {
      if (hits[i]) {
        builder.append(word.charAt(i));
      } else {
        builder.append("?");
      }
    }

    builder.append("\n\n");
    return builder.toString();
  }
}
