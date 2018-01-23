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

package hangman.mistakes;

import oo.atom.tests.Assertion;
import org.assertj.core.api.Assertions;

public class AssertMistakesCountdown implements Assertion {
    private final Mistakes mistakes;

    public AssertMistakesCountdown(final Mistakes mistakes) {
        this.mistakes = mistakes;
    }

    @Override
    public final void check() throws Exception {
        final int max = mistakes.max();
        final int countedDown = mistakes.countDown();
        final int newCurrent = mistakes.current();
        final int newMax = mistakes.max();

        Assertions
            .assertThat(countedDown)
            .withFailMessage("countedDown/new current difference mismatch: <%s> vs <%s>", countedDown, newCurrent)
            .isEqualTo(newCurrent);
        Assertions
            .assertThat(max)
            .withFailMessage("newMax/max stability mismatch: <%s> vs <%s>", max, newMax)
            .isEqualTo(newMax);
    }
}
