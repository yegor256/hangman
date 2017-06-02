package cactoos.comparable.string;

import cactoos.convertible.string.ConvertedString;
import cactoos.convertible.string.Convertible;

/**
 * String equality.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Equal implements StringEquality {
        private final ConvertedString a;
        private final ConvertedString b;

        public Equal(final String a, final String b) {
                this(new Convertible(a), new Convertible(b));
        }       

        public Equal(final ConvertedString a, final ConvertedString b) {
                this.a = a;
                this.b = b;
        }

        @Override
        public boolean ok() {           
                return a.string().equals(b.string());
        }
}