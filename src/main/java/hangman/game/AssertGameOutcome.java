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

package hangman.game;

import hangman.input.Input;
import hangman.output.Output;
import hangman.output.OutputMock;
import oo.atom.tests.Assertion;

public class AssertGameOutcome implements Assertion {
    public interface AssertionSubject {
        Game game(Input input, Output output);
    }

    private final AssertionSubject subject;
    private final Input input;
    private final String expectedOutput;

    public AssertGameOutcome(final AssertionSubject subject, final Input input, final String expectedOutput) {
        this.subject = subject;
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Override
    public final void check() throws Exception {
        final OutputMock outputMock = new OutputMock(expectedOutput);
        final Game game = subject.game(input, outputMock);
        game.play();
        outputMock.check();
    }
}
