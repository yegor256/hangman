package hangman.manager;

import hangman.checker.CheckResult;
import hangman.checker.Checker;
import hangman.factory.WordFactory;
import hangman.reader.Reader;
import hangman.strategy.Strategy;
import hangman.strategy.status.DefaultGameStatus;
import hangman.strategy.status.GameStatus;
import hangman.strategy.status.StatusType;
import hangman.writer.Reporter;
import hangman.writer.Writer;

public class HangmanGame {

  private final Reader reader;

  private final Writer writer;

  private final WordFactory wordFactory;

  private final Strategy strategy;

  private final Checker checker;

  private final Reporter reporter;

  private final int maxMiss;

  private HangmanGame(
      Reader reader,
      Writer writer,
      WordFactory wordFactory,
      Strategy strategy,
      Checker checker,
      Reporter reporter,
      int maxMiss) {
    this.reader = reader;
    this.writer = writer;
    this.wordFactory = wordFactory;
    this.strategy = strategy;
    this.checker = checker;
    this.reporter = reporter;
    this.maxMiss = maxMiss;
  }

  public void start() {
    final String word = wordFactory.getWord();
    GameStatus status = new DefaultGameStatus(new boolean[word.length()], maxMiss);
    while (true) {
      status = round(word, status);
      if (!hasMoreRounds(status)) {
        break;
      }
    }

    printResult(status);
  }

  private GameStatus round(final String word, final GameStatus status) {
    writer.write("Guess a letter: ");

    int input = reader.read();
    CheckResult checkResult = checker.check(word, input);
    GameStatus newStatus = strategy.evaluate(status, checkResult);
    String roundReport = reporter.report(newStatus, word);
    writer.write(roundReport);

    return newStatus;
  }

  private boolean hasMoreRounds(GameStatus gameStatus) {
    return gameStatus.getResult() == StatusType.NOT_FINISHED;
  }

  private void printResult(GameStatus current) {
    if (current.getResult() == StatusType.LOSS) {
      writer.write("You lost");
    } else if (current.getResult() == StatusType.WIN) {
      writer.write("You won");
    }
  }

  public static Builder get() {
    return new Builder();
  }

  public static class Builder {
    private Reader reader;

    private Writer writer;

    private WordFactory factory;

    private Strategy strategy;

    private Checker checker;

    private Reporter reporter;

    private int maxMiss;

    public Builder reader(Reader reader) {
      checkArgument(reader != null);
      this.reader = reader;
      return this;
    }

    public Builder writer(Writer writer) {
      checkArgument(writer != null);
      this.writer = writer;
      return this;
    }

    public Builder factory(WordFactory factory) {
      checkArgument(factory != null);
      this.factory = factory;
      return this;
    }

    public Builder strategy(Strategy strategy) {
      checkArgument(strategy != null);
      this.strategy = strategy;
      return this;
    }

    public Builder checker(Checker checker) {
      checkArgument(checker != null);
      this.checker = checker;
      return this;
    }

    public Builder reporter(Reporter reporter) {
      checkArgument(reporter != null);
      this.reporter = reporter;
      return this;
    }

    public Builder maxMiss(int maxMiss) {
      checkArgument(maxMiss > 0);
      this.maxMiss = maxMiss;
      return this;
    }

    public HangmanGame build() {
      return new HangmanGame(reader, writer, factory, strategy, checker, reporter, maxMiss);
    }

    private void checkArgument(boolean expr){
      if(!expr){
        throw new IllegalArgumentException();
      }
    }
  }
}
