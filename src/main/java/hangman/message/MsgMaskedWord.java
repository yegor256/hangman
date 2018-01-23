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

package hangman.message;

import hangman.output.Output;
import hangman.word.Word;
import hangman.wordmask.WordMask;
import io.vavr.collection.List;

public class MsgMaskedWord implements Message {
    private final Word word;
    private final WordMask mask;
    private final Output output;

    public MsgMaskedWord(final Word word, final WordMask mask, final Output output) {
        this.word = word;
        this.mask = mask;
        this.output = output;
    }

    @Override
    public final void printOut() {
        output.printOut("The word: ");
        final String wordStr = word.string();
        final List<Boolean> mask = this.mask.mask();
        for (int i = 0; i < wordStr.length(); ++i) {
            if (mask.get(i)) {
                output.printOut(String.valueOf(wordStr.charAt(i)));
            } else {
                output.printOut("?");
            }
        }
        output.printOut("\n\n");
    }
}
