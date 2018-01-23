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

package hangman.gamestatus;

import hangman.mistakes.Mistakes;
import hangman.wordmask.WordMask;

public class GsImplementation implements GameStatus {
    private final Mistakes mistakes;
    private final WordMask wordMask;

    public GsImplementation(final Mistakes mistakes, final WordMask wordMask) {
        this.mistakes = mistakes;
        this.wordMask = wordMask;
    }

    @Override
    public final Value value() {
        boolean mistakesMax = mistakes.max() <= mistakes.current();
        boolean wordGuessed = wordMask.mask().filter(t -> !t).size() == 0;
        if(wordGuessed) {
            return Value.WORD_GUESSED;
        } else if(mistakesMax) {
            return Value.MISTAKES_LIMIT_REACHED;
        } else {
            return Value.IN_PROGRESS;
        }
    }
}
