package hangman;

import game.Output;
import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class WelcomeView implements View {
        private final Output output;

        public WelcomeView(final Output output) {
                this.output = output;
        }

        @Override
        public void show() {
                output.display("Guess a letter: ");
        }
}