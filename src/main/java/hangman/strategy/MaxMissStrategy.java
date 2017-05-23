package hangman.strategy;

import hangman.checker.CheckResult;
import hangman.strategy.status.DefaultGameStatus;
import hangman.strategy.status.StatusType;
import hangman.strategy.status.GameStatus;

public class MaxMissStrategy implements Strategy {
  private final int maxMisses;

  public MaxMissStrategy(final int maxMisses) {
    this.maxMisses = maxMisses;
  }

  @Override
  public GameStatus evaluate(GameStatus currentStatus, CheckResult checkResult) {
    int hitCount = currentStatus.getHitCount();
    int missCount = currentStatus.getMissCount();
    boolean[] currentHits = currentStatus.getHits();
    boolean newHit = false;

    if (checkResult.isHit()) {
      boolean[] checkHits = checkResult.hits();
      newHit = mergeHits(checkHits, currentHits);

      if (newHit) {
        hitCount++;
      } else {
        missCount++;
      }
    } else {
      missCount++;
    }

    StatusType statusType = statusType(missCount, currentHits);
    return new DefaultGameStatus(
        hitCount, missCount, newHit, currentHits, statusType, currentStatus.getMaxMissCount());
  }

  private StatusType statusType(int currentMissCount, boolean[] hits) {
    if (currentMissCount >= maxMisses) {
      return StatusType.LOSS;
    } else {
      boolean allFound = true;
      for (boolean hit : hits) {
        if (!hit) {
          allFound = false;
          break;
        }
      }

      return allFound ? StatusType.WIN : StatusType.NOT_FINISHED;
    }
  }

  private boolean mergeHits(boolean[] checkHits, boolean[] currentHits) {
    boolean newHit = false;
    for (int i = 0; i < checkHits.length; i++) {
      if (checkHits[i] && !currentHits[i]) {
        newHit = true;
        currentHits[i] = true;
      }
    }

    return newHit;
  }
}
