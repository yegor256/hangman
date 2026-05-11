package hangman;

import game.Output;
import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class LostView implements View {
        private final Output output;
        private final View source;

        public LostView(final Output output, final View source) {
                this.output = output;
                this.source = source;
        }

        @Override
        public void show() {
                source.show();
                output.display("\nYou lost.\n");
        }
}