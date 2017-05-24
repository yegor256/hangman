package hangman.game.console;

import hangman.game.Game;
import hangman.io.InOut;
import hangman.io.console.ConsoleInOut;

public class ConsoleGame extends Game {

	private final InOut inOut;

	public ConsoleGame() {
		inOut = new ConsoleInOut();
	}

	public ConsoleGame(int maxGuess) {
		super(maxGuess);
		inOut = new ConsoleInOut();
	}

	protected char getNextChar() {
		inOut.printMessage("Guess a letter: ");
		return inOut.readChar();
	}

	@Override
	protected void printCurrentHit(boolean success, int mistakes, int maxGuess) {
        if (success) {
        	inOut.printMessage("Hit!");
        } else {
        	inOut.printMessage("Missed, mistake #%d out of %d", mistakes, maxGuess);
        }

        inOut.printNewLine();
	}

	@Override
	protected void printNextTask(String taskWord) {
        inOut.printMessage("The word: ");
        inOut.printMessage(taskWord);

        inOut.printNewLine();
        inOut.printNewLine();
	}

	@Override
	protected void finishGame() {
		if (checkWin()) {
        	inOut.printMessage("You won!");
		} else {
			inOut.printMessage("You lost.");
		}

		inOut.printNewLine();
	}

	@Override
	protected void destroyGame() {
		try {
			inOut.close();
		} catch (Exception e) {
			// NOOP
		}
	}
}
