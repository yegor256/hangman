package hangman.strategy.status;

public interface GameStatus {

  boolean isHit();

  int getHitCount();

  int getMissCount();

  boolean[] getHits();

  int getMaxMissCount();

  StatusType getResult();
}
