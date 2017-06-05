package hangman;

import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class LostView implements View {
        @Override
        public void show() {
                System.out.println("You lost.\n");
        }
}