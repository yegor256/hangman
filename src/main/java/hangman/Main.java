package hangman;

import java.util.function.Supplier;

class Main implements Supplier<Boolean> {

	public static void main(String[] args) {
		System.out.format("You %s%n/", new Main().get() ? "won!" : "lost.");
	}

	@Override
	public Boolean get() {
		return false;
	}

}
