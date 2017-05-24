/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2017 Yegor Bugayenko
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 */
package hangman;

import hangman.Game.Game;
import hangman.Game.GameInterface;
import hangman.Round.*;
import hangman.Words.CachedWords;
import hangman.Words.RandomWords;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private final GameInterface game;
    private static final String[] WORDS = {
        "simplicity", "equality", "grandmother",
        "neighborhood", "relationship", "mathematics",
        "university",
        "explanation",
    };

    /**
     * See Bonus package to change game logic
     */
    public Main(final InputStream in, final OutputStream out, final int max) {

        this.game = new Game(
            new PrintStream(out),
            new CachedWords(new RandomWords(WORDS)),
            new MistakesTrack(max,
                new SolvedTrack(
                    new SuccessRoundTrack(
                        new PuzzleLog(
                            new Round(new Scanner(in))
                        )
                    )
                )
            )
        );
    }

    public static void main(final String... args) {
        new Main(System.in, System.out, 5).exec();
    }

    public void exec() {
        game.play();
    }

}
