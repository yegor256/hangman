package hangman;

import game.View;

public final class HangmanWonView implements View {

	@Override
	public void show() {		
		System.out.println("You won!\n");
	}
}