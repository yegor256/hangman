package hangman;

interface WordToGuess {

	void guess(char chr);

	boolean guessed();

	@Override
	String toString();

	static WordToGuess of(String str) {
		return null;
	}

}
