package hangman.checker;

public interface CheckResult {
  boolean isHit();

  boolean[] hits();
}
