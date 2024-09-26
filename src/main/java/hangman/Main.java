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

import game.Keyboard;
import game.Console;
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

    public Main(final InputStream in, final OutputStream out, final int m) {
        this.input = in;
        this.output = out;
        this.max = m;
    }

    public static void main(final String... args) {
        new Main(System.in, System.out, 5).exec();
    }

    public void exec() {
        try (final PrintStream out = new PrintStream(this.output)) {
            final Iterator<String> scanner = new Scanner(this.input);
            new NewGame(max, new Keyboard(scanner), new Console(out)).start();                                        
        }        
    }
}
