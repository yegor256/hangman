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

package hangman.word;

import hangman.vocabulary.Vocabulary;
import io.vavr.collection.List;

import java.util.Random;

class WPickedRandomlyFromVocabularyInference implements Word.Inference {
    private final Vocabulary vocabulary;
    private final long seed;

    public WPickedRandomlyFromVocabularyInference(final Vocabulary vocabulary, final long seed) {
        this.vocabulary = vocabulary;
        this.seed = seed;
    }

    @Override
    public final Word word() {
        final List<String> contents = vocabulary.contents();
        Random random = new Random(seed);
        final int i = random.nextInt(contents.size());
        return new WExplicit(
            contents.get(i)
        );
    }
}

public class WPickedRandomlyFromVocabulary extends WInferred implements Word {
    public WPickedRandomlyFromVocabulary(final Vocabulary vocabulary, final long seed) {
        super(
            new WPickedRandomlyFromVocabularyInference(
                vocabulary,
                seed
            )
        );
    }
}
