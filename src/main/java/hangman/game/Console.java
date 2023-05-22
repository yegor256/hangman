package game;

import java.io.PrintStream;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Console implements Output {
        private final PrintStream out;

        public Console(final PrintStream out) {
                this.out = out;
        }

        @Override
        public void display(String string) {
                out.print(string);
        }
}