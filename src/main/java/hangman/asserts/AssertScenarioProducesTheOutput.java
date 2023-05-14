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

package hangman.asserts;

import hangman.input.Input;
import hangman.output.OToStream;
import hangman.output.Output;
import oo.atom.tests.Assertion;
import org.assertj.core.api.Assertions;

import java.io.ByteArrayOutputStream;

public class AssertScenarioProducesTheOutput implements Assertion {
    @FunctionalInterface
    public interface Scenario {
        void execute(Output output);
    }

    private final Scenario scenario;
    private final String expectedOutput;

    public AssertScenarioProducesTheOutput(final Scenario scenario, final String expectedOutput) {
        this.scenario = scenario;
        this.expectedOutput = expectedOutput;
    }

    @Override
    public final void check() throws Exception {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        scenario.execute(
            new OToStream(
                byteArrayOutputStream
            )
        );
        final String string = byteArrayOutputStream.toString("UTF-8");
        Assertions.assertThat(string).isEqualTo(expectedOutput);
    }
}
