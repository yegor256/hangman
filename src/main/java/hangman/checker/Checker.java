package hangman.checker;

public interface Checker {
  CheckResult check(String word, int given);
}
