package word;

import cactoos.random.string.RandomString;
import cactoos.random.string.Random;
import character.Characters;

/**
 * Selection a new random word from an array of strings each time it is called.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class RandomWord implements NextWord {
	private final String[] words;
	private final RandomString randomString;

	public RandomWord(final String[] words) {		
		this(words, new Random(words));
	}	

	public RandomWord(final String[] words, final RandomString randomString) {
		this.words = words;
		this.randomString = randomString;
	}

	@Override
	public WordLetters next() {
		return 
		new CharactersAsWord(
			new Characters(
				randomString.next()));
	}
}