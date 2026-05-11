package hangman;

import game.Output;
import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class GuessedView implements View {
        private final Output output;

        public GuessedView(final Output output) {
                this.output = output;
        }

	@Override
	public void show() {
		output.display("Hit!\n");
	}
}