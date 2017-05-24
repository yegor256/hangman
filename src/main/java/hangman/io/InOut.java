package hangman.io;

public interface InOut {

	char readChar();

	void printMessage(char c);

	void printMessage(String message);

	void printMessage(String message, Object ... args);

	void printNewLine();

	void close();
}
