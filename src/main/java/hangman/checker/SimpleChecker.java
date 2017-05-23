package hangman.checker;

public class SimpleChecker implements Checker {
  @Override
  public CheckResult check(String word, int given) {
    boolean hit = false;
    boolean[] hits = new boolean[word.length()];
    for (int i = 0; i < word.length(); ++i) {
      if (word.charAt(i) == given) {
        hits[i] = true;
        hit = true;
      }
    }

    return new SimpleCheckResult(hit, hits);
  }
}
