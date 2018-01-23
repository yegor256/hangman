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

package hangman.input;

import oo.atom.anno.NotAtom;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

@NotAtom
class CachedScanner {
    private final String string;
    private Scanner scanner;

    public CachedScanner(final String string) {
        this.string = string;
    }

    public final synchronized Scanner getOrProduceScanner() {
        if(scanner == null) {
            scanner = new Scanner(
                new ByteArrayInputStream(string.getBytes())
            );
        }
        return scanner;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CachedScanner that = (CachedScanner) o;

        return string != null ? string.equals(that.string) : that.string == null;
    }

    @Override
    public int hashCode() {
        return string != null ? string.hashCode() : 0;
    }
}

public class IFromString implements Input {
    private final CachedScanner scanner;

    IFromString(final CachedScanner scanner) {
        this.scanner = scanner;
    }

    public IFromString(final String string) {
        this(
            new CachedScanner(
                string
            )
        );
    }

    @Override
    public final char claimedChar() {
        return scanner.getOrProduceScanner().nextLine().charAt(0);
    }
}
