/**
 * The MIT License (MIT)
 *
 * <p>Copyright (c) 2017 Yegor Bugayenko
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions: The above copyright notice and this
 * permission notice shall be included in all copies or substantial portions of the Software.
 */
package hangman;

import hangman.checker.SimpleChecker;
import hangman.factory.InMemoryWordFactory;
import hangman.manager.HangmanGame;
import hangman.reader.SimpleReader;
import hangman.strategy.MaxMissStrategy;
import hangman.writer.SimpleWriter;
import hangman.writer.RoundReporter;

public class Main {

  public static void main(final String... args) {
    final int maxMiss = 10;
    HangmanGame game =
        HangmanGame.get()
            .reader(new SimpleReader())
            .writer(new SimpleWriter())
            .factory(new InMemoryWordFactory())
            .strategy(new MaxMissStrategy(maxMiss))
            .checker(new SimpleChecker())
            .reporter(new RoundReporter())
            .maxMiss(maxMiss)
            .build();

    game.start();
  }
}
