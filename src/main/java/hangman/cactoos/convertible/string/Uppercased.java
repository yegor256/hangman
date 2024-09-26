package cactoos.convertible.string;

/**
 * Uppercased string.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Uppercased implements ConvertedString {
	private final String string;

	public Uppercased(final String string) {
		this.string = string;
	}

	@Override
	public String string() {		
		return string.toUpperCase();
	}
}