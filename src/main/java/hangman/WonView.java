package hangman;

import game.Output;
import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class WonView implements View {
        private final Output output;

        public WonView(final Output output) {
                this.output = output;
        }

	@Override
	public void show() {
		output.display("You won!\n");
	}
}