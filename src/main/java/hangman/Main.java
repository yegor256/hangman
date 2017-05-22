/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Yegor Bugayenko
 *
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

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private final InputStream input;
    private final OutputStream output;
    private final int max;
    private static final String[] WORDS = {
        "simplicity", "equality", "grandmother",
        "neighborhood", "relationship", "mathematics",
        "university", "explanation"
    };

    public Main(final InputStream in, final OutputStream out, final int m) {
        this.input = in;
        this.output = out;
        this.max = m;
    }

    public static void main(final String... args) {
        new Main(System.in, System.out, 5).exec();
    }

    public void exec() {
        String word = WORDS[new Random().nextInt(WORDS.length)];
        boolean[] visible = new boolean[word.length()];
        int mistakes = 0;
        try (final PrintStream out = new PrintStream(this.output)) {
            final Iterator<String> scanner = new Scanner(this.input);
            boolean done = true;
            while (mistakes < this.max) {
                done = true;
                for (int i = 0; i < word.length(); ++i) {
                    if (!visible[i]) {
                        done = false;
                    }
                }
                if (done) {
                    break;
                }
                out.print("Guess a letter: ");
                char chr = scanner.next().charAt(0);
                boolean hit = false;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) == chr && !visible[i]) {
                        visible[i] = true;
                        hit = true;
                    }
                }
                if (hit) {
                    out.print("Hit!\n");
                } else {
                    out.printf(
                        "Missed, mistake #%d out of %d\n",
                        mistakes + 1, this.max
                    );
                    ++mistakes;
                }
                out.append("The word: ");
                for (int i = 0; i < word.length(); ++i) {
                    if (visible[i]) {
                        out.print(word.charAt(i));
                    } else {
                        out.print("?");
                    }
                }
                out.append("\n\n");
            }
            if (done) {
                out.print("You won!\n");
            } else {
                out.print("You lost.\n");
            }
        }
    }

}
