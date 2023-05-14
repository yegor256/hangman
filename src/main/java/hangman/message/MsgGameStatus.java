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

import hangman.gamestatus.GameStatus;
import hangman.output.Output;
import static hangman.gamestatus.GameStatus.Value.*;

public class MsgGameStatus implements Message {
    private final GameStatus status;
    private final Output output;

    public MsgGameStatus(final GameStatus status, final Output output) {
        this.status = status;
        this.output = output;
    }

    @Override
    public final void printOut() {
        if(MISTAKES_LIMIT_REACHED.equals(status.value())) {
            output.printOut("You lost!\n");
            return;
        }
        if(WORD_GUESSED.equals(status.value())) {
            output.printOut("You win!\n");
            return;
        }
    }
}
