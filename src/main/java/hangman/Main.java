package hangman;

class Main implements Game {

	public static void main(String[] args) {
		// TODO: 5 and "university" from args
		System.out.format("You %s%n/", new Main().play(5, WordToGuess.of("university")) ? "won!" : "lost.");
	}

	@Override
	public boolean play(int maxGuessAttempts, WordToGuess wordToGuess) {
		return false;
	}

}
