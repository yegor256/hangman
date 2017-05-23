package hangman.writer;

import hangman.strategy.status.GameStatus;

public interface Reporter {
  String report(GameStatus status, String word);
}
