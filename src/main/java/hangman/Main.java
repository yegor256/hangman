package hangman;

class Main implements Game {

	public static void main(String[] args) {
		boolean won = new Main().play(args);
		System.out.format("You %s%n/", won ? "won!" : "lost.");
	}

	@Override
	public boolean play(String[] args) {
		return false;
	}

}
