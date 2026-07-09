package game;

import java.util.Iterator;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Keyboard implements CharInput {
        private final Iterator<String> in;

        public Keyboard(final Iterator<String> in) {
                this.in = in;
        }

        @Override
        public char next() {
                return in.next().charAt(0);
        }
}