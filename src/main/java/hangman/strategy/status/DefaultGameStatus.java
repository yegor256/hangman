package hangman.strategy.status;

import java.util.Arrays;

public class DefaultGameStatus implements GameStatus {
  private final int hitCount;

  private final int missCount;

  private final boolean isHit;

  private final boolean[] hits;

  private final StatusType result;

  private final int maxMissCount;

  public DefaultGameStatus(boolean[] hits, int maxMissCount) {
    this(0, 0, false, hits, StatusType.NOT_FINISHED, maxMissCount);
  }

  public DefaultGameStatus(
      int hitCount,
      int missCount,
      boolean isHit,
      boolean[] hits,
      StatusType result,
      int maxMissCount) {
    this.hitCount = hitCount;
    this.missCount = missCount;
    this.hits = Arrays.copyOf(hits, hits.length);
    this.result = result;
    this.isHit = isHit;
    this.maxMissCount = maxMissCount;
  }

  @Override
  public boolean isHit() {
    return isHit;
  }

  @Override
  public int getHitCount() {
    return hitCount;
  }

  @Override
  public int getMissCount() {
    return missCount;
  }

  @Override
  public boolean[] getHits() {
    return hits;
  }

  @Override
  public int getMaxMissCount() {
    return maxMissCount;
  }

  @Override
  public StatusType getResult() {
    return result;
  }

  @Override
  public String toString() {
    return "DefaultGameStatus{"
        + "hitCount="
        + hitCount
        + ", missCount="
        + missCount
        + ", result="
        + result
        + '}';
  }
}
