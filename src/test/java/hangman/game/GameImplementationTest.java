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

import hangman.input.IFromString;
import hangman.input.Input;
import hangman.output.Output;
import hangman.word.WExplicit;
import oo.atom.tests.TestCase;
import oo.atom.tests.TestsSuite;

import static org.junit.Assert.*;

public class GameImplementationTest extends TestsSuite {
    public GameImplementationTest() {
        super(
            new TestCase(
                "",
                new AssertGameOutcome(
                    new AssertGameOutcome.AssertionSubject() {
                        @Override
                        public final Game game(final Input input, final Output output) {
                            return new GameImplementation(
                                output,
                                input,
                                new WExplicit("test"),
                                5
                            );
                        }
                    },
                    new IFromString("a\na\na\na\na\n"),
                    "The word: ????\n" +
                    "\n" +
                    "Guess a letter: Missed, mistake #1 out of 5\n" +
                    "The word: ????\n" +
                    "\n" +
                    "Guess a letter: Missed, mistake #2 out of 5\n" +
                    "The word: ????\n" +
                    "\n" +
                    "Guess a letter: Missed, mistake #3 out of 5\n" +
                    "The word: ????\n" +
                    "\n" +
                    "Guess a letter: Missed, mistake #4 out of 5\n" +
                    "The word: ????\n" +
                    "\n" +
                    "Guess a letter: Missed, mistake #5 out of 5\n" +
                    "You lost!\n"
                )
            )
        );
    }
}