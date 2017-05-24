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

import java.util.Random;

public class Main {

    private static final String[] WORDS = {
            "simplicity", "equality", "grandmother",
            "neighborhood", "relationship", "mathematics",
            "university", "explanation"
    };

    public static void main(String[] args) {
        SuperHangman johnny = new SuperHangman(
                new WordKeeper(WORDS[new Random().nextInt(WORDS.length)]), 5);
        johnny.trySurvive();
    }
}
