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

import hangman.game.GameImplementation;
import hangman.input.IFromStream;
import hangman.output.OToStream;
import hangman.vocabulary.VocStatic;
import oo.atom.anno.NotAtom;

@NotAtom
public class Main {
    private static final String[] WORDS = {
        "simplicity", "equality", "grandmother",
        "neighborhood", "relationship", "mathematics",
        "university", "explanation"
    };

    public static void main(final String... args) {
        new Main().exec();
    }

    public void exec() {
        new GameImplementation(
            new OToStream(System.out),
            new IFromStream(System.in),
            new VocStatic(WORDS),
            5,
            System.currentTimeMillis()
        ).play();
    }
}
