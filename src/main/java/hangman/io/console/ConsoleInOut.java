package hangman.io.console;

import java.io.PrintStream;
import java.util.Scanner;

import hangman.io.InOut;

public class ConsoleInOut implements InOut {

	private static final String NEW_LINE = "\n";

    private final Scanner input;

    private final PrintStream output;

	public ConsoleInOut() {
		input = new Scanner(System.in);
		output = new PrintStream(System.out);
	}

	@Override
	public char readChar() {
		return input.next().charAt(0);
	}

	@Override
	public void printMessage(char c) {
		output.print(c);
	}

	@Override
	public void printMessage(String message) {
		output.print(message);
	}

	@Override
	public void printMessage(String message, Object... args) {
		output.printf(message, args);
	}

	@Override
	public void printNewLine() {
		output.print(NEW_LINE);
	}

	@Override
	public void close() {
		input.close();
		output.close();
	}
}
