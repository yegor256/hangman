/*
 * The MIT License
 *
 * Copyright 2018 Kapralov Sergey.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package hangman.guess;

import com.sun.org.apache.xpath.internal.operations.Bool;
import hangman.input.Input;
import hangman.word.Word;
import hangman.wordmask.WordMask;
import io.vavr.collection.List;

public class GImplementation implements Guess {
    private final Input input;
    private final Word word;
    private final WordMask wordMask;

    public GImplementation(final Input input, final Word word, final WordMask wordMask) {
        this.input = input;
        this.word = word;
        this.wordMask = wordMask;
    }

    @Override
    public final boolean hit() {
        char chr = input.claimedChar();
        String word1 = word.string();
        final List<Boolean> visible = wordMask.mask();
        boolean hit = false;
        for (int i = 0; i < word1.length(); ++i) {
            if (word1.charAt(i) == chr && !visible.get(i)) {
                wordMask.open(i);
                hit = true;
            }
        }
        return hit;
    }
}
