package cactoos.convertible.string;

/**
 * Lowercased string.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Lowercased implements ConvertedString {
	private final String string;

	public Lowercased(final String string) {
		this.string = string;
	}

	@Override
	public String string() {		
		return string.toLowerCase();
	}
}