package hangman;

import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class WonView implements View {
	@Override
	public void show() {
		System.out.println("You won!\n");
	}
}