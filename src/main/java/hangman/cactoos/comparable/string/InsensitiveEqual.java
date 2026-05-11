package cactoos.comparable.string;

import cactoos.convertible.string.Lowercased;

/**
 * String equality.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class InsensitiveEqual implements StringEquality {
        private final String a;
        private final String b;

        public InsensitiveEqual(final String a, final String b) {
                this.a = a;
                this.b = b;
        }

        @Override
        public boolean ok() {           
                return new Equal(new Lowercased(a), new Lowercased(b)).ok();
        }
}