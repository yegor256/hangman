package hangman;

import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class WelcomeView implements View {
        @Override
        public void show() {
                System.out.println("Guess a letter: ");
        }
}