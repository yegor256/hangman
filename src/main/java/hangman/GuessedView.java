package hangman;

import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class GuessedView implements View {
	@Override
	public void show() {
		System.out.println("Hit!\n");
	}
}