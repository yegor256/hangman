package word;

/**
 * Selection a new random word from an array of strings each time it is called.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class RandomWords implements NextWord {
    private static final String[] DEFAULT_WORDS = {
        "simplicity", "equality", "grandmother",
        "neighborhood", "relationship", "mathematics",
        "university", "explanation"
    }; 
	private final NextWord source;

	public RandomWords() {
		this(DEFAULT_WORDS);
	}

	public RandomWords(final String[] source) {
		this.source = new RandomWord(source);
	}

	@Override
	public Word next() {
		return source.next();
	}
}