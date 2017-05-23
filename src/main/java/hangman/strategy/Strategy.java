package hangman.strategy;

import hangman.checker.CheckResult;
import hangman.strategy.status.GameStatus;

public interface Strategy {
  GameStatus evaluate(GameStatus currentStatus, CheckResult checkResult);
}
