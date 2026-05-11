package cactoos.random.string;

/**
 * Selecting a new random string from an array of strings.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Random implements RandomString {
	private final String[] strings;

	public Random(final String[] strings) {
		this.strings = strings;
	}

	@Override
	public String next() {
		return strings[new java.util.Random().nextInt(strings.length)];		
	}
}