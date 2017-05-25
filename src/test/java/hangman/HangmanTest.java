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

import hangman.word.SimpleWord;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public final class HangmanTest {

    @Test
    public void failsAfterManyWrongAttempts() throws Exception {
        final ByteArrayInputStream input = new ByteArrayInputStream(
                "a\n".getBytes()
        );

        final StringBuilder outputString = new StringBuilder();
        final PrintWriter writer = new PrintWriter(new OutputStream() {
            @Override
            public void write(int i) throws IOException {
                outputString.append((char) i);
            }
        }, true);

        new Hangman(
                writer,
                new Computer(new SimpleWord("b")),
                new Human(new Scanner(input)),
                1
        ).start();


        assertThat(outputString.toString(), containsString("You lost"));
    }

}
