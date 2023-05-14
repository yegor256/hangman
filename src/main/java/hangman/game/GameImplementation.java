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

import hangman.gamestatus.GameStatus;
import hangman.gamestatus.GsImplementation;
import hangman.guess.GImplementation;
import hangman.guess.GLimited;
import hangman.guess.GVerbose;
import hangman.guess.Guess;
import hangman.input.IGentle;
import hangman.input.Input;
import hangman.memory.BitmaskMemory;
import hangman.memory.MistakesMemory;
import hangman.message.*;
import hangman.mistakes.Mistakes;
import hangman.mistakes.MstMemoized;
import hangman.output.Output;
import hangman.vocabulary.Vocabulary;
import hangman.word.WPickedRandomlyFromVocabulary;
import hangman.word.Word;
import hangman.wordmask.WmMemoized;
import hangman.wordmask.WordMask;

public class GameImplementation implements Game {
    private final Guess guesses;
    private final GameStatus status;
    private final Message gameStatusMsg;

    private GameImplementation(final Guess guesses, final GameStatus status, final Message gameStatusMsg) {
        this.guesses = guesses;
        this.status = status;
        this.gameStatusMsg = gameStatusMsg;
    }

    private GameImplementation(Output output, Input input, Word word, Mistakes mistakes, WordMask mask) {
        this(
            new GVerbose(
                new MsgHit(
                    output
                ),
                new MsgMissedAttempt(
                    mistakes,
                    output
                ),
                new MsgMaskedWord(
                    word,
                    mask,
                    output
                ),
                new GLimited(
                    mistakes,
                    new GImplementation(
                        new IGentle(
                            new MsgInputInvitation(
                                output
                            ),
                            input
                        ),
                        word,
                        mask
                    )
                )
            ),
            new GsImplementation(
                mistakes,
                mask
            ),
            new MsgGameStatus(
                new GsImplementation(
                    mistakes,
                    mask
                ),
                output
            )
        );
    }

    public GameImplementation(Output output, Input input, Word word, int maxMistakes) {
        this(
            output,
            input,
            word,
            new MstMemoized(
                new MistakesMemory(
                    maxMistakes
                )
            ),
            new WmMemoized(
                new BitmaskMemory(
                    word
                )
            )
        );
    }

    public GameImplementation(Output output, Input input, Vocabulary vocabulary, int maxMistakes, long seed) {
        this(
            output,
            input,
            new WPickedRandomlyFromVocabulary(
                vocabulary,
                seed
            ),
            maxMistakes
        );
    }

    @Override
    public final void play() {
        while(status.value().equals(GameStatus.Value.IN_PROGRESS)) {
            guesses.hit();
            gameStatusMsg.printOut();
        }
    }
}
