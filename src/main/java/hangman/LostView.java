package hangman;

import game.Output;
import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class LostView implements View {
        private final Output output;

        public LostView(final Output output) {
                this.output = output;
        }

        @Override
        public void show() {
                output.display("You lost.\n");
        }
}