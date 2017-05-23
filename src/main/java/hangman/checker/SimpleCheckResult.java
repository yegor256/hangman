package hangman.checker;

import java.util.Arrays;

public class SimpleCheckResult implements CheckResult {

  private final boolean hit;

  private final boolean[] hitIndexes;

  public SimpleCheckResult(boolean hit, boolean[] hitIndexes) {
    this.hit = hit;
    this.hitIndexes = Arrays.copyOf(hitIndexes, hitIndexes.length);
  }

  @Override
  public boolean isHit() {
    return hit;
  }

  @Override
  public boolean[] hits() {
    return hitIndexes;
  }
}
